package ChapterJDBC.Connector;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class SettingLoader {

    private static Properties properties = new Properties();
    private String url;
    private String userName;
    private String password;


    public static SettingLoader loadSettingsFromFile(String fileName) throws IOException {
        properties.load(new FileInputStream(fileName));
        SettingLoader settingLoader = new SettingLoader();
        settingLoader.setDatabaseConfig();
        return settingLoader;
    }

    private void setDatabaseConfig() {
        url = properties.getProperty("database.url");
        userName = properties.getProperty("database.host");
        password = properties.getProperty("database.password");
    }

    public String getUrl() {
        if (Objects.isNull(url)) {
            return ""
        }
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}

