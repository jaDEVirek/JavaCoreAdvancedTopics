package ChapterJDBC.Connector;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class SettingLoader implements AutoCloseable {

    private static Properties properties = new Properties();
    private String url;
    private String userName;
    private String password;


    public static SettingLoader loadSettingsFromFile(String fileName) throws IOException, ClassNotFoundException {
        properties.load(new FileInputStream("src/main/resources/"+fileName));
        SettingLoader settingLoader = new SettingLoader();
        settingLoader.setDatabaseConfig();
        Class.forName("com.mysql.jdbc.Driver");
        return settingLoader;
    }

    private void setDatabaseConfig() {
        url = properties.getProperty("database.url");
        userName = properties.getProperty("database.host");
        password = properties.getProperty("database.password");
    }

    public String getUrl() {
        return Objects.isNull(url) ? "" : url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override public void close() {

    }
}

