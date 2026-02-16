package ui.pages.components;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import java.nio.file.Paths;

/**
 * Component for file upload and download operations.
 */
public class FileActions extends BaseComponent {

    public FileActions(Page page) {
        super(page);
    }

    @Step("Upload file '{filePath}' to: {selector}")
    public void uploadFile(String selector, String filePath) {
        getLocator(selector).setInputFiles(Paths.get(filePath));
    }

    @Step("Download file from: {selector}")
    public Download download(String selector) {
        return page.waitForDownload(() -> getLocator(selector).click());
    }
}

