package tests;

import com.microsoft.playwright.*;
import framework.Injector;
import framework.Pages;
import framework.Steps;

import java.util.List;

public class AbstractTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected Injector injector;
    protected Pages pages;
    protected Steps steps;

    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(getLaunchOptions(false));
        context = browser.newContext();
        page = context.newPage();
        injector = new Injector(page);
//        pages = new Pages(page);
        steps = new Steps(injector);
    }

    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }

    private BrowserType.LaunchOptions getLaunchOptions(boolean isHeadless) {
        return new BrowserType.LaunchOptions()
                .setHeadless(isHeadless)
                .setArgs(List.of("--window-size=1920,1080"))
                .setSlowMo(50);
    }
}
