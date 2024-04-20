package ru.otus.java.homeworks.homework17;

import java.sql.*;

public class User {
    public static Connection connection;

    public static void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "username TEXT PRIMARY KEY, " +
                    "role TEXT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean authenticateUser(String username, String role) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND role = ?")) {
            statement.setString(1, username);
            statement.setString(2, role);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Вернет true, если пользователь существует
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}