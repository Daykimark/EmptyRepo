package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() throws SQLException {

    }

    public void createUsersTable() throws SQLException {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS users" +
                    "(id BIGINT NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(15) NOT NULL," +
                    "lasName VARCHAR(25) NOT NULL," +
                    "age TINYINT NOT NULL," +
                    "PRIMARY KEY(id));");
        } catch (SQLException ignored) {

        }
    }

    public void dropUsersTable() throws SQLException {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("DROP TABLE IF EXISTS users;");
        } catch (SQLException ignored) {

        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String query = "INSERT INTO users (name, lasName, age) values (?, ?, ?);";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, name);
            st.setString(2, lastName);
            st.setByte(3, age);
            st.executeUpdate();
        } catch (SQLException ignored) {

        }
        System.out.println("User с именем - " + name + " был добавлен в таблицу");
    }

    public void removeUserById(long id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?;";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException ignored) {

        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> allUsers = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet set = st.executeQuery("SELECT * FROM users;");
            while (set.next()) {
                allUsers.add(new User(set.getString(2), set.getString(3), set.getByte(4)));
            }
        } catch (SQLException ignored) {

        }
        return allUsers;
    }

    public void cleanUsersTable() throws SQLException {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("TRUNCATE users;");
        } catch (SQLException ignored) {

        }
    }
    public void closeConnection() throws SQLException {
        Util.closeConnection();
    }
}
