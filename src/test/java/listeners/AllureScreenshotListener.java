package listeners;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.ByteArrayInputStream;

public class AllureScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot(result, "FAILED_" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        attachScreenshot(result, "SKIPPED_" + result.getName());
    }

    private void attachScreenshot(ITestResult result, String name) {
        Object instance = result.getInstance();
        if (!(instance instanceof BaseTest baseTest)) {
            return;
        }
        try {
            Page page = baseTest.getPage();
            if (page == null || page.isClosed()) {
                return;
            }
            byte[] screenshot = page.screenshot(
                    new Page.ScreenshotOptions().setFullPage(true)
            );
            getAttachment(screenshot, name);
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    private void getAttachment(byte[] screenshot, String name) {
        Allure.addAttachment(
                "Screenshot: " + name,
                "image/png",
                new ByteArrayInputStream(screenshot),
                "png"
        );
    }
}

