package pages;

import enums.textBox.InputTextBoxValues;
import io.qameta.allure.Step;

public class TextBoxPage extends BasePage {
    private final String INPUT_VALUE = "#%s";
    private final String SUBMIT_BUTTON = "#submit";
    private final String OUTPUT_VALUE = "//p[@id='%s']";
    private final String OUTPUT_CONTAINER = "#output";
    private final String EMAIL_FIELD = "#userEmail";

    @Step("Enter value '{value}' into field: {locatorName.locator}")
    public void enterInputValue(InputTextBoxValues locatorName, String value) {
        if (value != null) {
            element.enterValue(String.format(INPUT_VALUE, locatorName.getLocator()), value);
        }
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        element.click(SUBMIT_BUTTON);
    }

    @Step("Validate output field '{fieldName}' has value: {expectedValue}")
    public void validateOutputField(String locatorName, String fieldName, String expectedValue) {
        assertion.validateText(String.format(OUTPUT_VALUE, locatorName), fieldName + expectedValue);
    }

    @Step("Validate output field is not displayed: {locatorName}")
    public boolean isOutputFieldDisplayed(String locatorName) {
        return getLocator(String.format(OUTPUT_VALUE, locatorName)).count() > 0;
    }

    @Step("Check if email field has error border")
    public boolean hasEmailFieldErrorBorder() {
        String className = getLocator(EMAIL_FIELD).getAttribute("class");
        if (className != null && className.contains("error")) {
            return true;
        }
        String borderColor = getLocator(EMAIL_FIELD).evaluate("el => getComputedStyle(el).borderColor").toString();
        return borderColor.contains("rgb(255, 0, 0)")
                || borderColor.contains("255, 0, 0")
                || borderColor.contains("red");
    }

    @Step("Validate output container is visible")
    public boolean isOutputContainerVisible() {
        return element.isVisible(OUTPUT_CONTAINER);
    }
}
