package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Step;

/**
 * Component for wait-related operations on elements and page conditions.
 */
public class WaitActions extends BaseComponent {

    public WaitActions(Page page) {
        super(page);
    }

    @Step("Wait for element to be visible: {selector}")
    public void waitForVisible(String selector) {
        waitFor(selector, WaitForSelectorState.VISIBLE);
    }

    @Step("Wait for element to be hidden: {selector}")
    public void waitForHidden(String selector) {
        waitFor(selector, WaitForSelectorState.HIDDEN);
    }

    @Step("Wait for element to be enabled: {selector}")
    public void waitForEnabled(String selector) {
        page.waitForCondition(() -> getLocator(selector).isEnabled());
    }

    @Step("Wait for URL to contain: {partialUrl}")
    public void waitForUrlContains(String partialUrl) {
        page.waitForURL("**" + partialUrl + "**");
    }

    private void waitFor(String selector, WaitForSelectorState state) {
        getLocator(selector).waitFor(new Locator.WaitForOptions().setState(state));
    }
}

