package ui.pages;

import ui.enums.Category;
import io.qameta.allure.Step;

import java.util.List;

public class ElementsPage extends BasePage {
    public static final String ACCORDION = "//div[@class='accordion']";
    public static final String CATEGORY = "//div[@class='header-text' and contains(normalize-space(.), '%s')]";
    public static final String SUB_CATEGORY = "//span[contains(., '%s')]/parent::*";
    public static final String SUB_ELEMENTS = "//span[@class='text']";

    @Step("Open category: {panelElement.category}")
    public void openCategory(Category panelElement) {
        element.click(String.format(CATEGORY, panelElement.getCategory()));
    }

    @Step("Open sub-category: {subCategory}")
    public void openSubCategory(String subCategory) {
        element.click(String.format(SUB_CATEGORY, subCategory));
    }

    @Step("Get all panel elements")
    public List<String> getAllPanelElements() {
        return element.getAllTexts(SUB_ELEMENTS);
    }
}
