package ChapterJDBC.Connector;

import ChapterJDBC.Dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOEmployee {
      String tableName;
    public String insertEmployee(EmployeeDTO employee, Connection con) throws SQLException {
        String sql = " %'tableName' INSERT INTO employee VALUES (?,?,?,?,?)";
        con.prepareStatement(sql);
    }

}
