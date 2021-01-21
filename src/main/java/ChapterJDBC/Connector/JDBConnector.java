package ChapterJDBC.Connector;


import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnector {


    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection()){

        }
    }

}
