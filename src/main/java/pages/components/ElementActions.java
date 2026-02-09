package pages.components;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import java.util.List;

/**
 * Component for basic element interactions like clicking, filling inputs, and getting text.
 */
public class ElementActions extends BaseComponent {

    public ElementActions(Page page) {
        super(page);
    }

    @Step("Click on element: {selector}")
    public void click(String selector) {
        getLocator(selector).click();
    }

    @Step("Enter value '{value}' into: {selector}")
    public void enterValue(String selector, String value) {
        getLocator(selector).fill(value);
    }

    @Step("Get text from: {selector}")
    public String getText(String selector) {
        return getLocator(selector).innerText();
    }

    @Step("Get all texts from: {selector}")
    public List<String> getAllTexts(String selector) {
        return getLocator(selector).allTextContents();
    }

    @Step("Check if element is visible: {selector}")
    public boolean isVisible(String selector) {
        return getLocator(selector).isVisible();
    }

    @Step("Check if element is enabled: {selector}")
    public boolean isEnabled(String selector) {
        return getLocator(selector).isEnabled();
    }

    @Step("Check if element is checked: {selector}")
    public boolean isChecked(String selector) {
        return getLocator(selector).isChecked();
    }

    @Step("Check checkbox: {selector}")
    public void check(String selector) {
        getLocator(selector).check();
    }

    @Step("Uncheck checkbox: {selector}")
    public void uncheck(String selector) {
        getLocator(selector).uncheck();
    }
}

