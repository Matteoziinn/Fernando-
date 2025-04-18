package org.app.gerparque.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new IOException("File ' db.properties ' not found ");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty (String key) {
        return properties.getProperty(key);
    }

}
