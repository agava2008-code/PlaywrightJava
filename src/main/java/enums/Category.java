package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum Category {
    ELEMENTS("Elements", "/elements"),
    FORMS("Forms", "/forms"),
    ALERTS_FRAME_WINDOWS("Alerts, Frame & Windows", "/alertsWindows"),
    WIDGETS("Widgets", "/widgets"),
    INTERACTIONS("Interactions", "/interaction"),
    BOOK_STORE_APPLICATION("Book Store Application", "/books");

    private final String category;
    private final String categoryUrl;

    public static List<String> getCategoryNames() {
        return Arrays.stream(Category.values())
                .map(Category::getCategory)
                .collect(Collectors.toList());
    }

    public static List<String> getCategoryUrls() {
        return Arrays.stream(Category.values())
                .map(Category::getCategoryUrl)
                .collect(Collectors.toList());
    }
}
