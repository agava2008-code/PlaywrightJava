package ui.pages.components;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

/**
 * Component for JavaScript execution operations.
 */
public class JsActions extends BaseComponent {

    public JsActions(Page page) {
        super(page);
    }

    @Step("Execute JavaScript")
    public Object executeJs(String script) {
        return page.evaluate(script);
    }

    @Step("Execute JavaScript with argument")
    public Object executeJs(String script, Object arg) {
        return page.evaluate(script, arg);
    }
}

