package enums.textBox;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InputTextBoxValues {
    FULL_NAME("Full Name", "userName"),
    EMAIL("Email", "userEmail"),
    CURRENT_ADDRESS("Current Address", "currentAddress"),
    PERMANENT_ADDRESS("Permanent Address", "permanentAddress");

    private final String fieldName;
    private final String locator;
}
