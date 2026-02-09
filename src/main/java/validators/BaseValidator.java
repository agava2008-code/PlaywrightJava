package validators;

import io.qameta.allure.Step;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseValidator {
    @Step("Validate equals: {message}")
    public static <T> void validateEquals(T actual, T expected, String message) {
        assertThat(actual).as(message).isEqualTo(expected);
    }

    @Step("Validate not equals: {message}")
    public static <T> void validateNotEquals(T actual, T expected, String message) {
        assertThat(actual).as(message).isNotEqualTo(expected);
    }

    @Step("Validate not null: {message}")
    public static <T> void validateNotNull(T actual, String message) {
        assertThat(actual).as(message).isNotNull();
    }

    @Step("Validate null: {message}")
    public static <T> void validateNull(T actual, String message) {
        assertThat(actual).as(message).isNull();
    }

    @Step("Validate collection not empty: {message}")
    public static <T> void validateNotEmpty(Collection<T> actual, String message) {
        assertThat(actual).as(message).isNotEmpty();
    }

    @Step("Validate array not empty: {message}")
    public static <T> void validateNotEmpty(T[] actual, String message) {
        assertThat(actual).as(message).isNotEmpty();
    }


}