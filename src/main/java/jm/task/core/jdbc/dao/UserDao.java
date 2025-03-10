package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserDao {

    String CREATE = "CREATE TABLE IF NOT EXISTS users (" +
            "id SERIAL PRIMARY KEY," +
            "name VARCHAR(64) NOT NULL," +
            "last_name VARCHAR(64) NOT NULL," +
            "age SMALLINT not NULL);";

    String DROP = "DROP TABLE IF EXISTS users;";
    String CLEAN = "TRUNCATE TABLE users;";


    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
