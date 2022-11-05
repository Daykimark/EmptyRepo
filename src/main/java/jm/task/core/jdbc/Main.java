package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 *
 * @author doraemon
 */



public class Main {

    public static void main(String[] args) throws SQLException {

        Session session = new UserDaoHibernateImpl().sessionFactory.openSession();

        UserService user = new UserServiceImpl();
        user.dropUsersTable();

        user.createUsersTable();
        user.saveUser("Mark", "Bazilevich", (byte) 19);
        user.saveUser("Mark", "Bazilevich", (byte) 20);
        System.out.println(user.getAllUsers());
        user.cleanUsersTable();
    }
}
