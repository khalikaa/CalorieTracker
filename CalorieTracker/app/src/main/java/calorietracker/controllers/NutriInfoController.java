package calorietracker.controllers;

import java.util.ArrayList;
import java.util.List;

import calorietracker.config.DbConfig;
import calorietracker.models.NutriInfo;

public class NutriInfoController extends DbConfig {    
    public static List<NutriInfo> getAllFood() {
        List<NutriInfo> foods = new ArrayList<>();
        query = "SELECT * FROM nutri_info";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                int energi = resultSet.getInt("energi");
                int protein = resultSet.getInt("protein");
                int lemak = resultSet.getInt("lemak");
                int karbohidrat = resultSet.getInt("karbohidrat");
                int berat = resultSet.getInt("berat");
                NutriInfo nutriInfo = new NutriInfo(id, nama, energi, protein, lemak, karbohidrat, berat);
                foods.add(nutriInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foods;
    }
}