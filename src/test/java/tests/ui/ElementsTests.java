package tests.ui;

import ui.enums.Category;
import ui.enums.SubCategory;
import org.testng.annotations.Test;
import tests.BaseTest;
import validators.BaseValidator;

import java.util.List;

public class ElementsTests extends BaseTest {
    public static final List<String> EXPECTED_SUB_CATEGORIES = SubCategory.getSubCategoryNames();
    public static final String SUBCATEGORIES_NOT_MATCH = "Subcategories do not match expected values";

    @Test
    public void validateTestElements() {
        steps.main.openApplication(Category.ELEMENTS);
        List<String> actualSubCategories = steps.elementSteps.getSubElements();
        BaseValidator.validateEquals(actualSubCategories, EXPECTED_SUB_CATEGORIES, SUBCATEGORIES_NOT_MATCH);
    }
}
