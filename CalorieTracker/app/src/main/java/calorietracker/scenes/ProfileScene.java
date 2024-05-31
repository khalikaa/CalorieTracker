package calorietracker.scenes;

import calorietracker.controllers.UserProfileController;
import calorietracker.models.UserProfile;
import calorietracker.util.UIUtil;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProfileScene {
    private Stage stage;
    private UserProfile userProfile;

    public ProfileScene(Stage stage, UserProfile userProfile) {
        this.stage = stage;
        this.userProfile = userProfile;
    }

    public void show(int id) {
        this.userProfile = UserProfileController.getProfileByUserId(id);

        Pane root = new Pane();
        BackgroundImage backgroundImage = UIUtil.createBackgroundImage("/images/profile_scene.png", 750, 500);
        Background background = new Background(backgroundImage);
        root.setBackground(background);
        
        Label labelTitle = new Label("Angka Kecukupan Gizi Saya");
        UIUtil.setupLabelLayout(labelTitle, 240, 25, 268, 21);

        Label labelAKG = new Label("AKG Saat Ini:\t\t\t" + userProfile.getCalorieNeeds());
        Label labelNama = new Label("Nama:\t\t\t\t" + userProfile.getName());
        Label labelUsia = new Label("Usia:\t\t\t\t\t" + userProfile.getAge());
        Label labelBB = new Label("Berat Badan:\t\t\t" + userProfile.getHeight());
        Label labelTB = new Label("Tinggi Badan:\t\t\t" + userProfile.getWeight());
        Label labelJK = new Label("Jenis Kelamin:\t\t\t" + userProfile.getGender());
        Label labelTA = new Label("Tingkat Aktivitas:\t\t" + userProfile.getActivityLevel());
        Label labelProtein = new Label("Kebutuhan Protein:\t\t" + String.format("%.2f", userProfile.getProteinNeeds()) + " g");
        Label labelLemak = new Label("Kebutuhan Lemak:\t\t" + String.format("%.2f", userProfile.getFatNeeds()) + " g");
        Label labelKarbo = new Label("Kebutuhan Karbohidrat:\t" + String.format("%.2f", userProfile.getCarboNeeds()) + " g");

        Button hitungUlangButton = new Button("Hitung Ulang AKG");
        UIUtil.setupButtonLayout(hitungUlangButton, 212, 335, 325, 25);
        
        Button signOutButton = new Button("Sign Out");
        UIUtil.setupButtonLayout(signOutButton, 275, 400, 200, 30);

        Button buttonLaporan = new Button("LAPORAN HARIAN");
        buttonLaporan.getStyleClass().add("button-laporan");
        UIUtil.setupButtonLayout(buttonLaporan, 500, 400, 200, 30);
        buttonLaporan.setOnAction(e -> {
            DailyReportScene dailyReportScene = new DailyReportScene(stage);
            dailyReportScene.show(id);
        });

        VBox vBoxProfil = new VBox(labelAKG, labelNama, labelUsia, labelBB, labelTB, labelJK, labelTA, labelProtein, labelLemak, labelKarbo);
        UIUtil.setupVBoxLayout(vBoxProfil, 223, 90, 304, 233);
        
        root.getChildren().addAll(labelTitle, vBoxProfil, hitungUlangButton, signOutButton, buttonLaporan);
        Scene scene = new Scene(root, 750, 500);
        stage.setScene(scene);
        stage.show();
    }
}