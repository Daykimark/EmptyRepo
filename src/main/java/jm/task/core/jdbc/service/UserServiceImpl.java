package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao user = new UserDaoHibernateImpl();

    public UserServiceImpl() throws SQLException {
    }

    @Override
    public void createUsersTable() throws SQLException {
        user.createUsersTable();
    }

    @Override

    public void dropUsersTable() throws SQLException {
        user.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        user.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        user.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return user.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        user.cleanUsersTable();
    }
}
