package calorietracker.controllers;

import calorietracker.config.DbConfig;
import calorietracker.models.SelectedFood;
import java.util.ArrayList;
import java.util.List;

public class SelectedFoodController extends DbConfig {
     public static void addSelectedFood(int userId, SelectedFood food) {
        query = "INSERT INTO selected_foods(user_id, name, energy, protein, fat, carbohydrate, weight) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, food.getName());
            preparedStatement.setInt(3, food.getEnergy());
            preparedStatement.setDouble(4, food.getProtein());
            preparedStatement.setDouble(5, food.getFat());
            preparedStatement.setDouble(6, food.getCarbohydrate());
            preparedStatement.setDouble(7, food.getWeight());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<SelectedFood> getSelectedFoods(int userId) {
        List<SelectedFood> selectedFoods = new ArrayList<>();
        query = "SELECT * FROM selected_foods WHERE user_id = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int energy = resultSet.getInt("energy");
                double protein = resultSet.getDouble("protein");
                double fat = resultSet.getDouble("fat");
                double carbo =  resultSet.getDouble("carbohydrate");
                double weight = resultSet.getDouble("weight");
                int food_id = resultSet.getInt("food_id");
                SelectedFood selectedFood = new SelectedFood(userId, name, energy, protein, fat, carbo, weight, food_id);
                selectedFoods.add(selectedFood);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectedFoods;
    }

    public static void deleteSelectedFood(int foodId) {
        query = "DELETE FROM selected_foods WHERE food_id = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, foodId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllSelectedFoodsByUserId(int userId) {
        query = "DELETE FROM selected_foods WHERE user_id = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}