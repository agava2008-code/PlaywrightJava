package pages.components;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

/**
 * Component for iframe/frame interactions.
 */
public class FrameActions extends BaseComponent {

    public FrameActions(Page page) {
        super(page);
    }

    @Step("Get frame by name: {name}")
    public Frame getFrameByName(String name) {
        return page.frame(name);
    }

    @Step("Get frame by selector: {selector}")
    public Frame getFrameBySelector(String selector) {
        return getLocator(selector).elementHandle().contentFrame();
    }
}

