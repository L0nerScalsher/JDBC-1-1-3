package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDao userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();

        userDaoHibernate.saveUser("Name1", "LastName1", (byte) 25);
        userDaoHibernate.saveUser("Name2", "LastName2", (byte) 26);
        userDaoHibernate.saveUser("Name3", "LastName3", (byte) 27);

        userDaoHibernate.removeUserById(1);

        List<User> userList = userDaoHibernate.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        userDaoHibernate.removeUserById(3);
        System.out.println("-----------------------------");

        List<User> userList2 = userDaoHibernate.getAllUsers();
        for (User user : userList2) {
            System.out.println(user);
        }

        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
        Util.closeSessionFactory();

    }
}
