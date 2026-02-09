package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CategoryApp {
    ELEMENTS("Elements", "elements"),
    FORMS("Forms", "forms"),
    ALERTS_FRAME_WINDOWS("Alerts, Frame & Windows", "alertsWindows"),
    WIDGETS("Widgets", "widgets"),
    INTERACTIONS("Interactions",  "interaction"),
    BOOK_STORE_APPLICATION("Book Store Application", "books");

    @Getter
    private final String category;
    @Getter
    private final String categoryUrl;
}
