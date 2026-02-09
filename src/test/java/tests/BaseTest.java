package tests;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyUtils;

public class BaseTest extends AbstractTest {
    protected static final String BASE_URL = PropertyUtils.getBaseUrl();

    public Page getPage() {
        return page;
    }

    @BeforeMethod
    public void configSetup() {
        super.setUp();
    }

    @BeforeMethod
    public void openBaseUrl() {
        page.navigate(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

    public void openUrl(String url) {
        page.navigate(url);
    }

    protected String getUrl() {
        return page.url();
    }

    protected String getTitle() {
        return page.title();
    }

    protected void back() {
        page.goBack();
    }

    protected void forward() {
        page.goForward();
    }
}
