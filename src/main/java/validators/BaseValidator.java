package validators;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseValidator {
    public static <T> void validateEquals(T actual, T expected, String message) {
        assertThat(actual).as(message).isEqualTo(expected);
    }

    public static <T> void validateNotEquals(T actual, T expected, String message) {
        assertThat(actual).as(message).isNotEqualTo(expected);
    }

    public static <T> void validateNotNull(T actual, String message) {
        assertThat(actual).as(message).isNotNull();
    }

    public static <T> void validateNull(T actual, String message) {
        assertThat(actual).as(message).isNull();
    }

    public static <T> void validateNotEmpty(Collection<T> actual, String message) {
        assertThat(actual).as(message).isNotEmpty();
    }

    public static <T> void validateNotEmpty(T[] actual, String message) {
        assertThat(actual).as(message).isNotEmpty();
    }

    public static void validateTitleAndUri(String actualTitle, String expectedTitle, String actualUrl, String expectedUrl) {
        assertThat(actualTitle).as("Page title does not match expected value").isEqualTo(expectedTitle);
        assertThat(actualUrl).as("Page URL does not match expected value").isEqualTo(expectedUrl);
    }
}