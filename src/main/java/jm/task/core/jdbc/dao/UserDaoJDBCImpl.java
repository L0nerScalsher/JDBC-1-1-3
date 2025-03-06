package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private final Connection conn = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS public.users\n" +
                "(\n" +
                "    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),\n" +
                "    name character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                "    lastname character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                "    age smallint NOT NULL,\n" +
                "    CONSTRAINT users_pkey PRIMARY KEY (id, name, lastname, age)\n" +
                ")\n";


        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users;";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
