package ui.pages;

import com.microsoft.playwright.*;
import ui.pages.components.*;
import ui.pages.components.*;

/**
 * Base page class that provides access to all page interaction components.
 * Uses composition to provide specialized component classes for different actions.
 * All page objects should extend this class and use the components directly.
 */
public abstract class BasePage {

    protected Page page;

    // Component classes for different actions
    protected ElementActions element;
    protected WaitActions wait;
    protected MouseActions mouse;
    protected KeyboardActions keyboard;
    protected DropdownActions dropdown;
    protected NavigationActions navigation;
    protected FileActions file;
    protected FrameActions frame;
    protected AssertionActions assertion;
    protected JsActions js;

    /**
     * Initializes the page components.
     * @param page The Playwright page object.
     */
    protected void initComponents(Page page) {
        this.page = page;
        this.element = new ElementActions(page);
        this.wait = new WaitActions(page);
        this.mouse = new MouseActions(page);
        this.keyboard = new KeyboardActions(page);
        this.dropdown = new DropdownActions(page);
        this.navigation = new NavigationActions(page);
        this.file = new FileActions(page);
        this.frame = new FrameActions(page);
        this.assertion = new AssertionActions(page);
        this.js = new JsActions(page);
    }

    protected Locator getLocator(String selector) {
        return page.locator(selector);
    }
}
