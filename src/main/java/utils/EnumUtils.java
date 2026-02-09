package utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class EnumUtils {
    public static <T extends Enum<T>> List<T> getEnumConstants(Class<T> enumClass) {
        return Arrays.asList(enumClass.getEnumConstants());
    }

    public static <T extends Enum<T>, R> List<R> getEnumValuesList(Class<T> enumClass, Function<T, R> mapper) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(mapper)
                .toList();
    }

    public static <T extends Enum<T>, R> String[] getEnumValuesArray(Class<T> enumClass, Function<T, R> mapper) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(mapper)
                .toArray(String[]::new);
    }

    public static <T extends Enum<T>, R> List<String> getEnumValuesList(Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::name)
                .toList();
    }

    public static <T extends Enum<T>> List<T> getEnumsList(Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .toList();
    }


}
