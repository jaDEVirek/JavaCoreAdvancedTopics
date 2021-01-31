package ChapterJDBC.Connector;


import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDBConnector {


    public static void main(String[] args) {
        try (SettingLoader settings = SettingLoader.loadSettingsFromFile(
                "settings.properties"); Connection con = DriverManager.getConnection(settings.getUrl(),
                settings.getUserName(),
                settings.getPassword())) {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select SUM(total_sales), client_id from company.works_with group by client_id");
            List<String> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
                result.add(resultSet.getString(2));
            }
            System.out.println(result);
            System.out.println(getUnion(statement));
            System.out.println(getNameSubQuery(statement));
            System.out.println(getSQLJoin(statement));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getUnion(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery(
                "SELECT client_name, client.branch_id FROM CLIENT union SELECT supplier_name, branch_supplier.branch_id from branch_supplier");
        List<String> result = new ArrayList<>();
        while(resultSet.next()){
            result.add("Name: " + resultSet.getString(1)+ "client_id: " + resultSet.getString(2));
        }
        return result;
    }

    private static String getNameSubQuery(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery(
                "SELECT client.client_name FROM CLIENT where client.branch_id = (SELECT branch.branch_id FROM branch where branch.mgr_id=102) ");
        List<String> result = new ArrayList<>();
        while(resultSet.next()){
            result.add(resultSet.getString("client_name"));
        }
        return result.toString();
    }

    private static String getSQLJoin(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery(
                "SELECT  client.client_id, client.client_name, branch_supplier.supplier_name FROM CLIENT JOIN branch_supplier on client.branch_id = branch_supplier.branch_id GROUP BY client_id, supplier_name ");
        List<String> result = new ArrayList<>();
        while(resultSet.next()){
            String s = resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3);
            result.add(s);
        }
        return result.toString();
    }
}
