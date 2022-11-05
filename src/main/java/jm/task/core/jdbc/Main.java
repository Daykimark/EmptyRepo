package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserService user = new UserServiceImpl();
        user.dropUsersTable();
        user.createUsersTable();
        user.saveUser("Mark", "Bazilevich", (byte) 19);
        user.saveUser("Mark", "Bazilevich", (byte) 20);
        System.out.println(user.getAllUsers());
        user.cleanUsersTable();
        user.dropUsersTable();
        user.closeConnection();
    }
}
