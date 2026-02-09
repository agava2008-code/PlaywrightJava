package builders;

import models.TextBoxModel;

import static utils.RandomUtils.*;

public class TextBoxModelBuilder {

    public static TextBoxModel buildDefaultTextBoxModel() {
        return TextBoxModel.builder()
                .fullName(getRandomName() + " " + getRandomSurname())
                .email(getRandomEmail())
                .currentAddress(getRandomAlphabetic(10) + getRandomAlphabetic(10))
                .permanentAddress(getRandomAlphabetic(10))
                .build();
    }

    public static TextBoxModel buildEmpty() {
        return TextBoxModel.builder().build();
    }
}
