package steps;

import enums.CategoryApp;
import pages.MainPage;

import java.util.List;

public class MainSteps {
    private MainPage mainPage;

    public MainSteps openApplication(CategoryApp category) {
        mainPage.openApplication(category);
        return this;
    }

    public List<String> getApplicationsNames() {
        return mainPage.getApplicationsNames();
    }

    public void validateTexts(String ... expectedTexts) {
        mainPage.validateTexts(expectedTexts);
    }
}
