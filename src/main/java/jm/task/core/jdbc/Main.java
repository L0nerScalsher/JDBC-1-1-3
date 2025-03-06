package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;


import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("vlad", "testoviy", (byte) 25);
        userDao.saveUser("vlad2", "priemniy", (byte) 25);
        userDao.saveUser("vlad3", "vlad", (byte) 25);

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
        System.out.println("-----------------------------");

        userDao.cleanUsersTable();

        List<User> userList3 = userDao.getAllUsers();
        for (User user : userList3) {
            System.out.println(user);
        }

        userDao.dropUsersTable();
    }
}
