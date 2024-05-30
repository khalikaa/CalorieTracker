package calorietracker.models;

public class UserProfile extends Model {
    int user_id, height, weight, age, calorie_needs;
    double proteinNeeds, fatNeeds, carboNeeds;
    String gender, activityLevel, dateCreated;
    
    public UserProfile(int id, int user_id, int height, int weight, int age, int calorie_needs, double proteinNeeds,
            double fatNeeds, double carboNeeds, String gender, String activityLevel, String dateCreated) {
        super(id);
        this.user_id = user_id;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.calorie_needs = calorie_needs;
        this.proteinNeeds = proteinNeeds;
        this.fatNeeds = fatNeeds;
        this.carboNeeds = carboNeeds;
        this.gender = gender;
        this.activityLevel = activityLevel;
        this.dateCreated = dateCreated;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public int getCalorie_needs() {
        return calorie_needs;
    }

    public void setCalorie_needs(int calorie_needs) {
        this.calorie_needs = calorie_needs;
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }    
}