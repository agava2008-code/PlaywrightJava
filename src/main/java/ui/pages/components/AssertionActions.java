package ui.pages.components;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Component for element assertions and validations.
 */
public class AssertionActions extends BaseComponent {

    public AssertionActions(Page page) {
        super(page);
    }

    @Step("Validate text '{expectedText}' in: {selector}")
    public void validateText(String selector, String expectedText) {
        assertThat(getLocator(selector)).hasText(expectedText);
    }

    @Step("Validate texts in: {selector}")
    public void validateTexts(String selector, String... expectedTexts) {
        assertThat(getLocator(selector)).hasText(expectedTexts);
    }

    @Step("Validate element is visible: {selector}")
    public void validateVisible(String selector) {
        assertThat(getLocator(selector)).isVisible();
    }

    @Step("Validate element is hidden: {selector}")
    public void validateHidden(String selector) {
        assertThat(getLocator(selector)).isHidden();
    }

    @Step("Validate element is enabled: {selector}")
    public void validateEnabled(String selector) {
        assertThat(getLocator(selector)).isEnabled();
    }

    @Step("Validate element contains text: {selector}")
    public void validateContainsText(String selector, String expectedText) {
        assertThat(getLocator(selector)).containsText(expectedText);
    }

    @Step("Validate element has attribute '{attribute}' with value '{value}'")
    public void validateAttribute(String selector, String attribute, String value) {
        assertThat(getLocator(selector)).hasAttribute(attribute, value);
    }
}

