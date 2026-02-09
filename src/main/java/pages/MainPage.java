package pages;

import enums.CategoryApp;

import java.util.List;

public class MainPage extends BasePage {
    private final String appContainer = "//h5";
    private final String category = "//h5[contains(text(),'%s')]";

    public void openApplication(CategoryApp cat) {
        executeClick(String.format(category, cat.getCategory()));
    }

    public List<String> getApplicationsNames() {
      return   getAllTexts(appContainer);
    }

    public void validateTexts(String ... expectedTexts) {
        validateTexts(appContainer, expectedTexts);
    }
}
