package steps;

import enums.textBox.InputTextBoxValues;
import io.qameta.allure.Step;
import models.TextBoxModel;
import pages.TextBoxPage;

import enums.textBox.OutputTextBoxValues;
import static enums.textBox.OutputTextBoxValues.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TextBoxSteps {
    TextBoxPage textBoxPage;

    @Step("Fill text box form and submit")
    public void fillTextBoxAndSubmit(TextBoxModel model) {
        fillTextBox(model);
        clickSubmitButton();
    }

    @Step("Fill text box form with: Full Name={model.fullName}, Email={model.email}")
    public void fillTextBox(TextBoxModel model) {
        textBoxPage.enterInputValue(InputTextBoxValues.FULL_NAME, model.getFullName());
        textBoxPage.enterInputValue(InputTextBoxValues.EMAIL, model.getEmail());
        textBoxPage.enterInputValue(InputTextBoxValues.CURRENT_ADDRESS, model.getCurrentAddress());
        textBoxPage.enterInputValue(InputTextBoxValues.PERMANENT_ADDRESS, model.getPermanentAddress());
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        textBoxPage.clickSubmitButton();
    }

    @Step("Validate text box output fields")
    public void validateTextBoxOutput(TextBoxModel model) {
        textBoxPage.validateOutputField(NAME.getLocator(), NAME.getText(), model.getFullName());
        textBoxPage.validateOutputField(EMAIL.getLocator(), EMAIL.getText(), model.getEmail());
        textBoxPage.validateOutputField(CURRENT_ADDRESS.getLocator(), CURRENT_ADDRESS.getText(), model.getCurrentAddress());
        textBoxPage.validateOutputField(PERMANENT_ADDRESS.getLocator(), PERMANENT_ADDRESS.getText(), model.getPermanentAddress());
    }

    @Step("Validate only filled fields are displayed in output")
    public void validateOnlyFilledFieldsDisplayed(TextBoxModel model) {
        validateFieldIfPresent(NAME, model.getFullName());
        validateFieldIfPresent(EMAIL, model.getEmail());
        validateFieldIfPresent(CURRENT_ADDRESS, model.getCurrentAddress());
        validateFieldIfPresent(PERMANENT_ADDRESS, model.getPermanentAddress());
    }

    private void validateFieldIfPresent(OutputTextBoxValues field, String value) {
        if (value != null) {
            textBoxPage.validateOutputField(field.getLocator(), field.getText(), value);
        } else {
            assertThat(textBoxPage.isOutputFieldDisplayed(field.getLocator()))
                    .as(field.getText() + " field should not be displayed").isFalse();
        }
    }

    @Step("Validate email field has no error border")
    public void validateEmailFieldHasNoErrorBorder() {
        assertThat(textBoxPage.hasEmailFieldErrorBorder())
                .as("Email field should not have red error border").isFalse();
    }

    @Step("Validate output is displayed")
    public void validateOutputIsDisplayed() {
        assertThat(textBoxPage.isOutputContainerVisible())
                .as("Output container should be visible").isTrue();
    }

    @Step("Validate output is not displayed")
    public void validateOutputIsNotDisplayed() {
        assertThat(textBoxPage.isOutputContainerVisible())
                .as("Output container should not be visible").isFalse();
    }

    @Step("Validate email field has error border")
    public void validateEmailFieldHasErrorBorder() {
        assertThat(textBoxPage.hasEmailFieldErrorBorder())
                .as("Email field should have red error border").isTrue();
    }

    @Step("Validate script injection is escaped in output")
    public void validateScriptInjectionEscaped(TextBoxModel model) {
        validateFieldIfPresent(NAME, model.getFullName());
        validateFieldIfPresent(CURRENT_ADDRESS, model.getCurrentAddress());
        validateFieldIfPresent(PERMANENT_ADDRESS, model.getPermanentAddress());
    }
}
