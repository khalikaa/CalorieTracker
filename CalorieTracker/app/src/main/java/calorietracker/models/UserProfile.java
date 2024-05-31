package calorietracker.models;

public class UserProfile extends Model {
    int user_id, height, weight, age, calorieNeeds;
    double proteinNeeds, fatNeeds, carboNeeds;
    String name, gender, activityLevel;

    public UserProfile() {}
    
    public UserProfile(String name, int id, int user_id, int height, int weight, int age, int calorieNeeds, double proteinNeeds,
            double fatNeeds, double carboNeeds, String gender, String activityLevel) {
        super(id);
        this.user_id = user_id;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.calorieNeeds = calorieNeeds;
        this.proteinNeeds = proteinNeeds;
        this.fatNeeds = fatNeeds;
        this.carboNeeds = carboNeeds;
        this.gender = gender;
        this.activityLevel = activityLevel;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCalorieNeeds() {
        return calorieNeeds;
    }

    public void setCalorieNeeds(int calorieNeeds) {
        this.calorieNeeds = calorieNeeds;
    }

    public double getProteinNeeds() {
        return proteinNeeds;
    }

    public void setProteinNeeds(double proteinNeeds) {
        this.proteinNeeds = proteinNeeds;
    }

    public double getFatNeeds() {
        return fatNeeds;
    }

    public void setFatNeeds(double fatNeeds) {
        this.fatNeeds = fatNeeds;
    }

    public double getCarboNeeds() {
        return carboNeeds;
    }

    public void setCarboNeeds(double carboNeeds) {
        this.carboNeeds = carboNeeds;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }    
}