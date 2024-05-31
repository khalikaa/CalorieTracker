package calorietracker.controllers;

import calorietracker.config.DbConfig;
import calorietracker.models.UserProfile;

import java.sql.SQLException;

public class UserProfileController extends DbConfig {
    public static boolean addProfile(int user_id, int height, int weight, int age, String gender, String activityLevel, int calorie_needs, double proteinNeeds,
                                     double fatNeeds, double carboNeeds) {
        query = "INSERT INTO user_profiles (user_id, height, weight, age, gender, activity_level, calorie_needs, protein_needs, fat_needs, carbo_needs) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            System.out.println("Testing berhasil");

            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, height);
            preparedStatement.setInt(3, weight);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, activityLevel);
            preparedStatement.setInt(7, calorie_needs);
            preparedStatement.setDouble(8, proteinNeeds);
            preparedStatement.setDouble(9, fatNeeds);
            preparedStatement.setDouble(10, carboNeeds);
            System.out.println("Testing berhasil 123");

            preparedStatement.executeUpdate();
            System.out.println("Berhasil menyimpan profil pengguna.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: Gagal menyimpan profil pengguna.");
        } finally {
            DbConfig.closeResources();
        }
        return false;

        
    }

    // public static UserProfile getProfilebyUserId(int user_id) {
    //     query = "SELECT * FROM users WHERE user_id=?";
    //     try {
    //         getConnection();
    //         preparedStatement = connection.prepareStatement(query);
    //         preparedStatement.setInt(1, id);
    //         resultSet = preparedStatement.executeQuery();
    //         try (ResultSet userResult = preparedStatement.executeQuery()) {
    //             while (resultSet.next()) {
    //                 String name = resultSet.getString("name");
    //                 String nim = resultSet.getString("nim");
    //                 String phoneNumber = resultSet.getString("phone_number");
    //                 String email = resultSet.getString("email");
    //                 String role = resultSet.getString("role");
    //                 int age = resultSet.getInt("age");
    //                 UserProfile profile = new UserProfile(id, name, nim, phoneNumber, email, role, age);
    //                 return user;
    //             }
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }

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
