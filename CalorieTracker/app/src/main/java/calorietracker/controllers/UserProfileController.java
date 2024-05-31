package calorietracker.controllers;

import calorietracker.config.DbConfig;
import calorietracker.models.UserProfile;

import java.sql.SQLException;

public class UserProfileController extends DbConfig {
    public static boolean addProfile(int user_id, String name, int height, int weight, int age, String gender, String activityLevel, int calorie_needs, double proteinNeeds,
                                     double fatNeeds, double carboNeeds) {
        query = "INSERT INTO user_profiles (user_id, name, height, weight, age, gender, activity_level, calorie_needs, protein_needs, fat_needs, carbo_needs) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, height);
            preparedStatement.setInt(4, weight);
            preparedStatement.setInt(5, age);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, activityLevel);
            preparedStatement.setInt(8, calorie_needs);
            preparedStatement.setDouble(9, proteinNeeds);
            preparedStatement.setDouble(10, fatNeeds);
            preparedStatement.setDouble(11, carboNeeds);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConfig.closeResources();
        }
        return false;
    }

    public static UserProfile getProfileByUserId(int userId) {
        UserProfile userProfile = null;
        String query = "SELECT * FROM user_profiles WHERE user_id = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userProfile = new UserProfile();
                userProfile.setName(resultSet.getString("name"));
                userProfile.setUser_id(resultSet.getInt("user_id"));
                userProfile.setHeight(resultSet.getInt("height"));
                userProfile.setWeight(resultSet.getInt("weight"));
                userProfile.setAge(resultSet.getInt("age"));
                userProfile.setGender(resultSet.getString("gender"));
                userProfile.setActivityLevel(resultSet.getString("activity_level"));
                userProfile.setCalorieNeeds(resultSet.getInt("calorie_needs"));
                userProfile.setProteinNeeds(resultSet.getDouble("protein_needs"));
                userProfile.setFatNeeds(resultSet.getDouble("fat_needs"));
                userProfile.setCarboNeeds(resultSet.getDouble("carbo_needs"));
            }
            DbConfig.closeResources();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userProfile;
    }
}