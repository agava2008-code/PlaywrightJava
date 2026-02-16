package ui.pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

/**
 * Component for keyboard-related interactions.
 */
public class KeyboardActions extends BaseComponent {

    public KeyboardActions(Page page) {
        super(page);
    }

    @Step("Press key: {key}")
    public void pressKey(String key) {
        page.keyboard().press(key);
    }

    @Step("Type slowly '{text}' into: {selector}")
    public void typeSlow(String selector, String text, int delayMs) {
        getLocator(selector).type(text, new Locator.TypeOptions().setDelay(delayMs));
    }
}

