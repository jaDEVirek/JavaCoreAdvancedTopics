package ChapterJDBC.Connector;


import java.sql.*;

public class JDBConnector {


    public static void main(String[] args) {
        try (SettingLoader settings = SettingLoader.loadSettingsFromFile(
                "settings.properties"); Connection con = DriverManager.getConnection(settings.getUrl(), settings.getUserName(),
                settings.getPassword())) {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select SUM(total_sales), client_id from company.works_with group by client_id");

          while(resultSet.next()){
              System.out.println(resultSet.getString(1));
              System.out.println(resultSet.getString(2));
          }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
