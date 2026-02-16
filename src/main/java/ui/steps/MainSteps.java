package ui.steps;

import ui.enums.Category;
import io.qameta.allure.Step;
import ui.pages.MainPage;

import java.util.List;

public class MainSteps {
    private MainPage mainPage;

    @Step("Open application category: {category.category}")
    public void openApplication(Category category) {
        mainPage.openApplication(category);
    }

    @Step("Get all application names")
    public List<String> getApplicationsNames() {
        return mainPage.getApplicationsNames();
    }

    @Step("Validate texts on main page")
    public void validateTexts(String... expectedTexts) {
        mainPage.validateTexts(expectedTexts);
    }
}
