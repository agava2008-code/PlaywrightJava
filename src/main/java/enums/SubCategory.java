package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum SubCategory {
    TEXT_BOX("Text Box", "/text-box"),
    CHECK_BOX("Check Box", "/checkbox"),
    RADIO_BUTTON("Radio Button", "/radio-button"),
    WEB_TABLES("Web Tables", "/webtables"),
    BUTTONS("Buttons", "/buttons"),
    LINKS("Links", "/links"),
    BROKEN_LINKS_IMAGES("Broken Links - Images", "/broken"),
    UPLOAD_AND_DOWNLOAD("Upload and Download", "/upload-download"),
    DYNAMIC_PROPERTIES("Dynamic Properties", "/dynamic-properties"),
    PRACTICE_FORM("Practice Form", "/automation-practice-form"),
    BROWSER_WINDOWS("Browser Windows", "/browser-windows"),
    ALERTS("Alerts", "/alerts"),
    FRAMES("Frames", "/frames"),
    NESTED_FRAMES("Nested Frames", "/nestedframes"),
    MODAL_DIALOGS("Modal Dialogs", "/modal-dialogs"),
    ACCORDIAN("Accordian", "/accordian"),
    AUTO_COMPLETE("Auto Complete", "/auto-complete"),
    DATE_PICKER("Date Picker", "/date-picker"),
    SLIDER("Slider", "/slider"),
    PROGRESS_BAR("Progress Bar", "/progress-bar"),
    TABS("Tabs", "/tabs"),
    TOOL_TIPS("Tool Tips", "/tool-tips"),
    MENU("Menu", "/menu"),
    SELECT_MENU("Select Menu", "/select-menu"),
    SORTABLE("Sortable", "/sortable"),
    SELECTABLE("Selectable", "/selectable"),
    RESIZABLE("Resizable", "/resizable"),
    DROPPABLE("Droppable", "/droppable"),
    DRAGABBLE("Dragabble", "/dragabble"),
    LOGIN("Login", "/login"),
    BOOK_STORE("Book Store", "/books"),
    PROFILE("Profile", "/profile"),
    BOOK_STORE_API("Book Store API", "/swagger");

    private final String category;
    private final String categoryUrl;

    public static List<String> getSubCategoryNames() {
        return Arrays.stream(SubCategory.values())
                .map(SubCategory::getCategory)
                .collect(Collectors.toList());
    }

    public static List<String> getSubCategoryUrls() {
        return Arrays.stream(SubCategory.values())
                .map(SubCategory::getCategoryUrl)
                .collect(Collectors.toList());
    }
}
