package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;


import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Name1", "LastName1", (byte) 25);
        userDao.saveUser("Name2", "LastName2", (byte) 26);
        userDao.saveUser("Name3", "LastName3", (byte) 27);

        userDao.removeUserById(1);

        List<User> userList = userDao.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        userDao.removeUserById(3);
        System.out.println("-----------------------------");

        List<User> userList2 = userDao.getAllUsers();
        for (User user : userList2) {
            System.out.println(user);
        }

        userDao.cleanUsersTable();

    }
}
