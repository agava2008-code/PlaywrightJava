package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public abstract class BasePage {
    protected Page page;

    protected ElementHandle getElementHandle(String selector) {
        return page.waitForSelector(selector);
    }

    protected Locator getLocator(String selector) {
//        page.locator(selector).waitFor();
        return page.locator(selector);
    }

    protected void executeClick(String selector) {
        getLocator(selector).click();
    }

    protected void enterValue(String selector, String value) {
        getLocator(selector).fill(value);
    }

    protected String getText(String selector) {
        return getLocator(selector).innerText();
    }

    protected void validateText(String selector, String expectedText) {
        assertThat(getLocator(selector)).hasText(expectedText);
    }

    protected List<String> getAllTexts(String selector) {
        return getLocator(selector).allTextContents();
    }

    protected void validateTexts(String selector, String... expectedTexts) {
        assertThat(getLocator(selector)).hasText(expectedTexts);
    }



}

