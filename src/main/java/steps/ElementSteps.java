package steps;

import enums.SubCategory;
import io.qameta.allure.Step;
import pages.ElementsPage;

import java.util.List;

public class ElementSteps {
    ElementsPage elementsPage;

    @Step("Open sub-category: {subCategory.category}")
    public void openSubCategory(SubCategory subCategory) {
        elementsPage.openSubCategory(subCategory.getCategory());
    }

    @Step("Get all sub-elements from panel")
    public List<String> getSubElements() {
        return elementsPage.getAllPanelElements();
    }
}
