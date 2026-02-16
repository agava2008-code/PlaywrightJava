package ui.pages.components;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import io.qameta.allure.Step;

/**
 * Component for dropdown/select element interactions.
 */
public class DropdownActions extends BaseComponent {

    public DropdownActions(Page page) {
        super(page);
    }

    @Step("Select by value '{value}' from: {selector}")
    public void selectByValue(String selector, String value) {
        getLocator(selector).selectOption(value);
    }

    @Step("Select by label '{label}' from: {selector}")
    public void selectByLabel(String selector, String label) {
        getLocator(selector).selectOption(new SelectOption().setLabel(label));
    }

    @Step("Select by index {index} from: {selector}")
    public void selectByIndex(String selector, int index) {
        getLocator(selector).selectOption(new SelectOption().setIndex(index));
    }
}

