package tests;

import enums.CategoryApp;
import org.testng.annotations.Test;
import utils.EnumUtils;
import validators.BaseValidator;
import validators.MainPageValidator;

import java.util.List;

public class MainPageTests extends BaseTest {
    public static final String BASE_URL = "https://demoqa.com/";
    public static final String APP_LIST = "Elements,Forms,Alerts,Frame & Windows,Widgets,Interactions,Book Store Application";
    public static final List<CategoryApp> APPL_LIST = EnumUtils.getEnumsList(CategoryApp.class);
    public static final List<String> APPL_LIST1 = EnumUtils.getEnumValuesList(CategoryApp.class, CategoryApp::getCategory);
    public static final String TITLE = "DEMOQA";
    public static final String URI = "https://demoqa.com/";

    @Test
    public void verifyManePageApps() {
        openUrl(BASE_URL);
        List<String> appNames = steps.main.getApplicationsNames();
        BaseValidator.validateEquals(appNames, APPL_LIST1, "Application names do not match expected values");
        steps.main.validateTexts(APPL_LIST1.toArray(String[]::new));
    }

    @Test
    public void validateTitleAnd() {
        openUrl(BASE_URL);
        MainPageValidator.validateTitleAndUri(getTitle(), TITLE, getUrl(), URI);
    }

    @Test
    public void validateAppsOpen() {
        openUrl(BASE_URL);
        APPL_LIST.forEach(
                app -> {
                    openAppAndValidate(app);
                    back();
                });

    }

    private void openAppAndValidate(CategoryApp app) {
        steps.main.openApplication(app);
        BaseValidator.validateTitleAndUri(getTitle(), TITLE, getUrl(), BASE_URL + app.getCategoryUrl());
    }

}
