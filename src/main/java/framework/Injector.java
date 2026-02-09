package framework;

import com.microsoft.playwright.Page;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static lombok.AccessLevel.PRIVATE;

/**
 * Dependency injection utility for Page Object Model classes.
 * Automatically injects Playwright Page instance and nested page objects
 * into fields using reflection.
 */
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class Injector {

    static String JAVA_PACKAGE_PREFIX = "java.";
    static String COMPONENTS_PACKAGE_PREFIX = "pages.components.";
    static String INIT_COMPONENTS_METHOD = "initComponents";

    Page playwrightPage;

    public <T> T get(Class<T> type) {
        try {
            T instance = createInstance(type);
            injectFields(instance, type);
            return instance;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Class " + type.getName() + " must have a no-arg constructor", e);
        } catch (Exception e) {
            throw new RuntimeException("Cannot create instance of " + type.getName(), e);
        }
    }

    private <T> T createInstance(Class<T> type) throws Exception {
        type.getDeclaredConstructor();
        return type.getDeclaredConstructor().newInstance();
    }

    private void injectFields(Object instance, Class<?> type) throws Exception {
        for (Class<?> current = type; current != Object.class; current = current.getSuperclass()) {
            for (Field field : current.getDeclaredFields()) {
                injectField(instance, field);
            }
        }
    }

    private void injectField(Object instance, Field field) throws Exception {
        if (shouldSkipField(field)) {
            return;
        }

        field.setAccessible(true);
        Class<?> fieldType = field.getType();

        if (isPlaywrightPage(fieldType)) {
            injectPageAndInitComponents(instance, field);
        } else if (isInjectableType(fieldType)) {
            field.set(instance, get(fieldType));
        }
    }

    private boolean shouldSkipField(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers);
    }

    private boolean isPlaywrightPage(Class<?> type) {
        return type == Page.class;
    }

    private boolean isInjectableType(Class<?> type) {
        return !type.isPrimitive()
                && !type.isEnum()
                && !type.isInterface()
                && !Modifier.isAbstract(type.getModifiers())
                && !type.getName().startsWith(JAVA_PACKAGE_PREFIX)
                && !type.getName().startsWith(COMPONENTS_PACKAGE_PREFIX);
    }

    private void injectPageAndInitComponents(Object instance, Field field) throws Exception {
        field.set(instance, playwrightPage);
        tryInitComponents(instance);
    }

    private void tryInitComponents(Object instance) {
        Method initMethod = findMethodInHierarchy(instance.getClass(), INIT_COMPONENTS_METHOD, Page.class);
        if (initMethod != null) {
            invokeMethod(instance, initMethod);
        }
    }

    private Method findMethodInHierarchy(Class<?> clazz, String methodName, Class<?>... paramTypes) {
        for (Class<?> current = clazz; current != null && current != Object.class; current = current.getSuperclass()) {
            try {
                return current.getDeclaredMethod(methodName, paramTypes);
            } catch (NoSuchMethodException e) {
                // Continue searching in superclass
            }
        }
        return null;
    }

    private void invokeMethod(Object instance, Method method) {
        try {
            method.setAccessible(true);
            method.invoke(instance, playwrightPage);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke " + method.getName() + " for " + instance.getClass().getName(), e);
        }
    }
}
