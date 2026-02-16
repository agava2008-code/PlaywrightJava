package tests.ui;

import ui.builders.TextBoxModelBuilder;
import ui.enums.Category;
import ui.enums.SubCategory;
import ui.models.TextBoxModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import static utils.RandomUtils.*;

public class TextBoxTests extends BaseTest {

    @BeforeMethod
    public void openTextBox() {
        steps.main.openApplication(Category.ELEMENTS);
        steps.elementSteps.openSubCategory(SubCategory.TEXT_BOX);
    }

    @Test
    public void validateTextBox() {
        TextBoxModel model = TextBoxModelBuilder.buildDefaultTextBoxModel();

        steps.textBoxSteps.fillTextBoxAndSubmit(model);
        steps.textBoxSteps.validateTextBoxOutput(model);
    }

    @Test
    public void validateSubmitOnlyRequiredFields() {
        TextBoxModel model = TextBoxModelBuilder.buildEmpty();
        model.setFullName(getRandomName() + " " + getRandomSurname());
        model.setEmail(getRandomEmail());

        steps.textBoxSteps.fillTextBoxAndSubmit(model);
        steps.textBoxSteps.validateOnlyFilledFieldsDisplayed(model);
    }

    @Test
    public void validateEmailWithValidFormat() {
        TextBoxModel model = TextBoxModelBuilder.buildEmpty();
        model.setEmail(getRandomEmail());

        steps.textBoxSteps.fillTextBoxAndSubmit(model);
        steps.textBoxSteps.validateOnlyFilledFieldsDisplayed(model);
        steps.textBoxSteps.validateOutputIsDisplayed();
        steps.textBoxSteps.validateEmailFieldHasNoErrorBorder();
    }

    @Test
    public void validateInvalidEmailFormat() {
        String invalidEmail = "abc@";
        TextBoxModel model = TextBoxModelBuilder.buildEmpty();
        model.setEmail(invalidEmail);

        steps.textBoxSteps.fillTextBoxAndSubmit(model);
        steps.textBoxSteps.validateEmailFieldHasErrorBorder();
        steps.textBoxSteps.validateOutputIsNotDisplayed();
    }

    @Test
    public void validateEmptyFormSubmission() {
        TextBoxModel model = TextBoxModelBuilder.buildEmpty();

        steps.textBoxSteps.fillTextBoxAndSubmit(model);
        steps.textBoxSteps.validateOutputIsNotDisplayed();
    }

    @Test
    public void validateScriptInjection() {
        String script = "<script>alert(1)</script>";
        TextBoxModel model = TextBoxModelBuilder.buildDefaultTextBoxModel();
        model.setFullName(script);

        steps.textBoxSteps.fillTextBoxAndSubmit(model);
        steps.textBoxSteps.validateOutputIsDisplayed();
        steps.textBoxSteps.validateScriptInjectionEscaped(model);
    }
}
