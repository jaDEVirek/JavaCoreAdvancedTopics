package ChapterJDBC.Connector;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingLoader {

    private static Properties properties = new Properties();
    private String url;
    private String userName;
    private String password;

    public static void loadSettingsFromFile(String fileName) throws IOException {
        properties.load(new FileInputStream(fileName));
        new SettingLoader().setDatabaseConfig();
    }

    private void setDatabaseConfig() {
        url= properties.getProperty("database.url");
        userName= properties.getProperty("database.host");
        password = properties.getProperty("database.password");
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}

