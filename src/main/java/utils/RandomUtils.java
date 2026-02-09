package utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    private static final Faker FAKER = new Faker();

    private RandomUtils() {
    }

    public static String getRandomName() {
        return FAKER.name().firstName();
    }

    public static String getRandomSurname() {
        return FAKER.name().lastName();
    }

    public static String getRandomEmail() {
        return FAKER.internet().emailAddress();
    }

    public static String getRandomAlphabetic(int length) {
        return FAKER.regexify("[a-zA-Z]{" + length + "}");
    }

    public static String getRandomAlphanumeric(int length) {
        return FAKER.regexify("[a-zA-Z0-9]{" + length + "}");
    }

    public static String getRandomNumeric(int length) {
        return FAKER.regexify("[0-9]{" + length + "}");
    }

    public static int getRandomInt(int bound) {
        return FAKER.number().numberBetween(0, bound);
    }

    public static int getRandomInt(int min, int max) {
        return FAKER.number().numberBetween(min, max + 1);
    }

    public static double getRandomDouble() {
        return FAKER.number().randomDouble(2, 0, 1);
    }

    public static double getRandomDouble(double min, double max) {
        return FAKER.number().randomDouble(2, (long) min, (long) max);
    }

    public static String getRandomUUID() {
        return FAKER.internet().uuid();
    }
}
