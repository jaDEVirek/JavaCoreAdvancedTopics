package ChapterJDBC.Connector;

import ChapterJDBC.Dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOEmployee {

    public String insertEmployee(EmployeeDTO employee, Connection con) throws SQLException {
        String sql = "INSERT INTO employee VALUES (?,?,?,?,?)";
        con.prepareStatement(sql);
    }

}
