package calorietracker.models;

public class SelectedFood extends Model{
    private int user_id, food_id;
    private String name;
    private int energy;
    private double protein;
    private double fat;
    private double carbohydrate;
    private double weight;

    public SelectedFood(int user_id, String name, int energy, double protein, double fat, double carbohydrate, double weight, int food_id) {
        this.user_id = user_id;
        this.name = name;
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.weight = weight;
        this.food_id = food_id;
    }

    public String getName() {
        return name;
    }

    public int getFoodId() {
        return food_id;
    }

    public int getEnergy() {
        return energy;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public double getWeight() {
        return weight;
    }

    public void setFoodId() {
        this.food_id = food_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
