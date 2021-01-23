package ChapterJDBC.Connector;


import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnector {


    public static void main(String[] args) {
        try (SettingLoader settings = SettingLoader.loadSettingsFromFile(
                "file"); Connection con = DriverManager.getConnection(settings.getUrl(), settings.getUserName(),
                settings.getPassword())) {
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
