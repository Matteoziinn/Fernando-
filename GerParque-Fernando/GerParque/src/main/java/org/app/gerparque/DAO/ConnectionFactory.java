package org.app.gerparque.DAO;

import com.sun.source.tree.BreakTree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        try {
           return DriverManager.getConnection(
                    ConfigManager.getProperty("db.url"),
                    ConfigManager.getProperty("db.user"),
                    ConfigManager.getProperty("db.password")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Driver não encontrado ou ",e);
        }
    }

}
