package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class Util {

    private static final String DB = "jdbc:postgresql://localhost:5432/FirstModuleDatabase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    private static Connection conn;
    private static SessionFactory sessionFactory;


    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(DB, USER, PASSWORD);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Соединение установлено");
        return conn;
    }


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = Util.getConfiguration();

            try {
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Соединение установлено");
        return sessionFactory;
    }


    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, DB);
        properties.put(Environment.USER, USER);
        properties.put(Environment.PASS, PASSWORD);
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        return configuration;
    }
}
