package tests.ui;

import enums.Category;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.EnumUtils;
import validators.BaseValidator;
import validators.MainPageValidator;

import java.util.List;

public class MainPageTests extends BaseTest {
    public static final List<Category> APPL_LIST = EnumUtils.getEnumsList(Category.class);
    public static final List<String> EXPECTED_CATEGORIES = Category.getCategoryNames();
    public static final String CATEGORIES_NOT_MATCH = "Categories do not match expected values";
    public static final String PAGE_TITLE = "demosite";

    @Test
    public void verifyMainPageApps() {
        List<String> actualCategories = steps.main.getApplicationsNames();
        BaseValidator.validateEquals(actualCategories, EXPECTED_CATEGORIES, CATEGORIES_NOT_MATCH);

        steps.main.validateTexts(EXPECTED_CATEGORIES.toArray(String[]::new));
    }

    @Test
    public void validateAppsOpen() {
        APPL_LIST.forEach(
                app -> {
                    validateTitleAndUrl(app);
                    back();
                });
    }

    public void validateTitleAndUrl(Category app) {
        steps.main.openApplication(app);
        MainPageValidator.validateTitleAndUri(getTitle(), PAGE_TITLE, getUrl(), BASE_URL + app.getCategoryUrl());
    }
}
