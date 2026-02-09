package validators;

import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageValidator extends BaseValidator {
    @Step("Validate page title is '{expectedTitle}' and URL is '{expectedUrl}'")
    public static void validateTitleAndUri(String actualTitle, String expectedTitle, String actualUrl, String expectedUrl) {
        assertThat(actualTitle).as("Page title does not match expected value").isEqualTo(expectedTitle);
        assertThat(actualUrl).as("Page URL does not match expected value").isEqualTo(expectedUrl);
    }
}
