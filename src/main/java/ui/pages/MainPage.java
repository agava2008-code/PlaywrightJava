package ui.pages;

import ui.enums.Category;
import io.qameta.allure.Step;

import java.util.List;

public class MainPage extends BasePage {
    private final String APP_CONTAINER = "//h5";
    private final String CATEGORY = "//h5[contains(text(),'%s')]";

    @Step("Open application: {cat.category}")
    public void openApplication(Category cat) {
        element.click(String.format(CATEGORY, cat.getCategory()));
    }

    @Step("Get all application names")
    public List<String> getApplicationsNames() {
        return element.getAllTexts(APP_CONTAINER);
    }

    @Step("Validate application texts")
    public void validateTexts(String... expectedTexts) {
        assertion.validateTexts(APP_CONTAINER, expectedTexts);
    }
}
