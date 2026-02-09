package pages;

import enums.Category;
import io.qameta.allure.Step;

import java.util.List;

public class MainPage extends BasePage {
    private final String appContainer = "//h5";
    private final String category = "//h5[contains(text(),'%s')]";

    @Step("Open application: {cat.category}")
    public void openApplication(Category cat) {
        element.click(String.format(category, cat.getCategory()));
    }

    @Step("Get all application names")
    public List<String> getApplicationsNames() {
        return element.getAllTexts(appContainer);
    }

    @Step("Validate application texts")
    public void validateTexts(String... expectedTexts) {
        assertion.validateTexts(appContainer, expectedTexts);
    }
}
