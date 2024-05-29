package calorietracker.controllers;

import java.sql.ResultSet;

import calorietracker.config.DbConfig;
import calorietracker.models.User;

public class UsersController extends DbConfig {
    public static User login(String username, String password) {
        query = "SELECT * FROM users WHERE username=? AND password=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet userResult = preparedStatement.executeQuery()) {
                if (userResult.next()) {
                    int id = userResult.getInt("id");
                    User user = new User(id, username);
                    return user; 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean register(String username, String password) {
        query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}