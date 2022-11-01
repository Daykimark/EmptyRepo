package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserService user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Mark", "Bazilevich", (byte) 19);
        user.saveUser("John", "Levich", (byte) 90);
        user.saveUser("Alexandr", "Voznik", (byte) 100);
        user.saveUser("Dead", "Inside", (byte) 1);
        user.getAllUsers().forEach(System.out::println);
        user.cleanUsersTable();
        user.dropUsersTable();
        user.closeConnection();
    }
}
