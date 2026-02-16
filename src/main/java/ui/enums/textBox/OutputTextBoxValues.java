package ui.enums.textBox;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OutputTextBoxValues {
    NAME("Name:", "name"),
    EMAIL("Email:", "email"),
    CURRENT_ADDRESS("Current Address :", "currentAddress"),
    PERMANENT_ADDRESS("Permananet Address :", "permanentAddress");

    private final String text;
    private final String locator;
}
