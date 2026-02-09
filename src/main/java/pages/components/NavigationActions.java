package pages.components;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

/**
 * Component for page navigation and URL operations.
 */
public class NavigationActions extends BaseComponent {

    public NavigationActions(Page page) {
        super(page);
    }

    @Step("Navigate to URL: {url}")
    public void navigate(String url) {
        page.navigate(url);
    }

    @Step("Get current URL")
    public String getCurrentUrl() {
        return page.url();
    }

    @Step("Go back")
    public void goBack() {
        page.goBack();
    }

    @Step("Go forward")
    public void goForward() {
        page.goForward();
    }

    @Step("Reload page")
    public void reload() {
        page.reload();
    }
}

