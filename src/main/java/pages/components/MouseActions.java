package pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import io.qameta.allure.Step;

/**
 * Component for mouse-related interactions like hovering, double-clicking, and scrolling.
 */
public class MouseActions extends BaseComponent {

    public MouseActions(Page page) {
        super(page);
    }

    @Step("Hover over: {selector}")
    public void hover(String selector) {
        getLocator(selector).hover();
    }

    @Step("Double click on: {selector}")
    public void doubleClick(String selector) {
        getLocator(selector).dblclick();
    }

    @Step("Right click on: {selector}")
    public void rightClick(String selector) {
        getLocator(selector).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }

    @Step("Scroll into view: {selector}")
    public void scrollIntoView(String selector) {
        getLocator(selector).scrollIntoViewIfNeeded();
    }

    @Step("Scroll to bottom of page")
    public void scrollToBottom() {
        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
    }
}

