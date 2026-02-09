package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends AbstractTest {
    private static final String BASE_URL = "https://demoqa.com";

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
