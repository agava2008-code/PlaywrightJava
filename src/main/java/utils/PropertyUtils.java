package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    public static final String ENVIRONMENT = "/base.properties";
    public static final String BASE_URL = "baseUri";

    public static String getBaseUrl() {
        return getProperty(BASE_URL);
    }

    public static String getProperty(String propertyName) {
        Properties prop = new Properties();
        try (InputStream input = PropertyUtils.class.getResourceAsStream(ENVIRONMENT)) {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load property: " + propertyName, e);
        }
        return prop.getProperty(propertyName);
    }
}
