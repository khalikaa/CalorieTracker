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

    public ProfileScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int user_id) {
        userProfile = UserProfileController.getProfileByUserId(user_id);

        Pane root = new Pane();
        BackgroundImage backgroundImage = UIUtil.createBackgroundImage("/images/profile_scene.png", 750, 500);
        Background background = new Background(backgroundImage);
        root.setBackground(background);
        
        Label labelTitle = new Label("Angka Kecukupan Gizi Saya");
        labelTitle.getStyleClass().add("label-title");
        UIUtil.setupLabelLayout(labelTitle, 216, 25, 322, 25);
        
        Label labelAKG = new Label("AKG Saat Ini:\t\t\t\t" + userProfile.getCalorieNeeds());
        labelAKG.getStyleClass().add("label-form");

        Label labelNama = new Label("Nama:\t\t\t\t\t" + userProfile.getName());
        labelNama.getStyleClass().add("label-form");
        
        Label labelUsia = new Label("Usia:\t\t\t\t\t" + userProfile.getAge());
        labelUsia.getStyleClass().add("label-form");

        Label labelBB = new Label("Berat Badan:\t\t\t\t" + userProfile.getWeight() + " kg");
        labelBB.getStyleClass().add("label-form");

        Label labelTB = new Label("Tinggi Badan:\t\t\t" + userProfile.getHeight() + " cm");
        labelTB.getStyleClass().add("label-form");

        Label labelJK = new Label("Jenis Kelamin:\t\t\t" + userProfile.getGender());
        labelJK.getStyleClass().add("label-form");

        Label labelTA = new Label("Tingkat Aktivitas:\t\t\t" + userProfile.getActivityLevel());
        labelTA.getStyleClass().add("label-form");

        Label labelProtein = new Label("Kebutuhan Protein:\t\t" + String.format("%.2f", userProfile.getProteinNeeds()) + " g");
        labelProtein.getStyleClass().add("label-form");

        Label labelLemak = new Label("Kebutuhan Lemak:\t\t" + String.format("%.2f", userProfile.getFatNeeds()) + " g");
        labelLemak.getStyleClass().add("label-form");

        Label labelKarbo = new Label("Kebutuhan Karbohidrat:\t" + String.format("%.2f", userProfile.getCarboNeeds()) + " g");
        labelKarbo.getStyleClass().add("label-form");

        Button buttonHitungUlang = new Button("Hitung Ulang AKG");
        buttonHitungUlang.getStyleClass().add("button-hitung-ulang");
        UIUtil.setupButtonLayout(buttonHitungUlang, 212, 335, 325, 25);
        buttonHitungUlang.setOnAction(e -> {
            AKGCountScene akgCountScene = new AKGCountScene(stage);
            akgCountScene.show();
        });

        Button buttonSingOut = new Button("SIGN OUT");
        buttonSingOut.getStyleClass().add("button-sign-out");
        UIUtil.setupButtonLayout(buttonSingOut, 275, 392, 200, 40);
        buttonSingOut.setOnAction(e-> {
            StartingScene startingScene = new StartingScene(stage);
            startingScene.show();
        });

        Label labelProfil = new Label("PROFIL SAYA");
        labelProfil.getStyleClass().add("label-profil");
        UIUtil.setupLabelLayout(labelProfil, 0, 450, 375, 50);
        
        Label labelLaporan = new Label("LAPORAN HARIAN");
        labelLaporan.getStyleClass().add("label-laporan");
        UIUtil.setupLabelLayout(labelLaporan, 375, 450, 375, 50);
        labelLaporan.setOnMouseClicked(e -> {
            DailyReportScene dailyReportScene = new DailyReportScene(stage);
            dailyReportScene.show(user_id);
        });

        VBox vBoxProfil = new VBox(labelAKG, labelNama, labelUsia, labelBB, labelTB, labelJK, labelTA, labelProtein, labelLemak, labelKarbo);
        UIUtil.setupVBoxLayout(vBoxProfil, 233, 85, 305, 233);
        
        root.getChildren().addAll(labelTitle, vBoxProfil, buttonHitungUlang, buttonSingOut, labelLaporan, labelProfil);
        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/profile-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}