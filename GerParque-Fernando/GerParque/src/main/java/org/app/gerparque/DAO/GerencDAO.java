package org.app.gerparque.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GerencDAO {

    protected Connection getConnectionGerc () throws SQLException {
     return ConnectionFactory.getConnection();
    }

    protected void CloseResources (Connection conn, PreparedStatement prStmt, ResultSet rst) throws SQLException{
        if (conn != null) conn.close();
        if (rst != null) rst.close();
        if (prStmt != null) prStmt.close();
    }

}
