package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB = "jdbc:postgresql://localhost:5432/FirstModuleDatabase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB, USER, PASSWORD);
            System.out.println("Соединение установлено");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
