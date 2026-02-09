package tests;

import com.microsoft.playwright.*;
import framework.Injector;
import framework.Steps;

import java.util.List;

public class AbstractTest {
    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> contextThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Injector> injectorThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Steps> stepsThreadLocal = new ThreadLocal<>();

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected Injector injector;
    protected Steps steps;

    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(getLaunchOptions(false));
        context = browser.newContext();
        page = context.newPage();
        injector = new Injector(page);
        steps = new Steps(injector);

        playwrightThreadLocal.set(playwright);
        browserThreadLocal.set(browser);
        contextThreadLocal.set(context);
        pageThreadLocal.set(page);
        injectorThreadLocal.set(injector);
        stepsThreadLocal.set(steps);
    }

    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();

        playwrightThreadLocal.remove();
        browserThreadLocal.remove();
        contextThreadLocal.remove();
        pageThreadLocal.remove();
        injectorThreadLocal.remove();
        stepsThreadLocal.remove();
    }

    private BrowserType.LaunchOptions getLaunchOptions(boolean isHeadless) {
        return new BrowserType.LaunchOptions()
                .setHeadless(isHeadless)
                .setArgs(List.of("--window-size=1920,1080"))
                .setSlowMo(50);
    }
}
