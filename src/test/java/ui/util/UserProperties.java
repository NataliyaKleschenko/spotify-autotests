package ui.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserProperties {
    protected static FileInputStream FIS;
    protected static Properties PROPERTIES;

    static {
        try {
            FIS = new FileInputStream("src/test/resources/credentials.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(FIS);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (FIS != null) {
                try {
                    FIS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
