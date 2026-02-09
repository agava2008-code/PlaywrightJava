package pages.components;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Base component providing core element access methods.
 * All other components extend this class to access page elements.
 */
public abstract class BaseComponent {

    protected final Page page;

    protected BaseComponent(Page page) {
        this.page = page;
    }

    protected ElementHandle getElementHandle(String selector) {
        return page.waitForSelector(selector);
    }

    protected Locator getLocator(String selector) {
        return page.locator(selector);
    }
}

