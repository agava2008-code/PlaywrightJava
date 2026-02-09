package framework;

import com.microsoft.playwright.Page;

import java.lang.reflect.Field;

public class Injector {
    private final Page playwrightPage;

    public Injector(Page playwrightPage) {
        this.playwrightPage = playwrightPage;
    }

    public <T> T get(Class<T> type) {
        try {
            T instance = type.getDeclaredConstructor().newInstance();
            injectFields(instance, type);
            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Cannot create instance of " + type.getName(), e);
        }
    }

    private void injectFields(Object instance, Class<?> type) throws Exception {
        Class<?> current = type;

        while (current != null && current != Object.class) {
            for (Field field : current.getDeclaredFields()) {
                field.setAccessible(true);

                // Inject Playwright Page into BasePage.page
                if (field.getType().equals(Page.class)) {
                    field.set(instance, playwrightPage);
                    continue;
                }

                // Recursively inject PageObjects or Steps
                if (!field.getType().isPrimitive()
                        && !field.getType().getName().startsWith("java.")) {

                    Object child = get(field.getType());
                    field.set(instance, child);
                }
            }

            current = current.getSuperclass();   // ← walk up the hierarchy
        }
    }
}



