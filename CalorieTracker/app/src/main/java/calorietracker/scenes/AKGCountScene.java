package calorietracker.scenes;

import calorietracker.controllers.UserProfileController;
import calorietracker.controllers.UsersController;
import calorietracker.models.UserProfile;
import calorietracker.util.SessionUtil;
import calorietracker.util.UIUtil;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AKGCountScene {
    private Stage stage;
    private TextField textFieldNama;
    private TextField textFieldUsia;
    private TextField textFieldBB;
    private TextField textFieldTB;
    private ComboBox<String> boxGender;
    private ComboBox<String> boxAktivitas;
    private Label labelHasil;
    private Label hasilHitungAKG;
    private Label labelNut1;
    private Label labelNut2;
    private Label labelStatus;
    private Button buttonSimpan;

    public AKGCountScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Pane root = new Pane();
        BackgroundImage backgroundImage = UIUtil.createBackgroundImage("/images/akg_scene.png", 750, 500);
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        Label labelTittle = new Label("Hitung Angka Kecukupan Gizi\n(AKG) Anda:");
        labelTittle.getStyleClass().add("label-tittle");
        UIUtil.setupLabelLayout(labelTittle, 50, 30, 265, 45);

        Label labelNama = new Label("Nama:");
        labelNama.getStyleClass().add("label-form");
        textFieldNama = new TextField();
        textFieldNama.getStyleClass().add("tf-form");

        Label labelUsia = new Label("Usia:");
        labelUsia.getStyleClass().add("label-form");
        textFieldUsia = new TextField();
        textFieldUsia.getStyleClass().add("tf-form");

        Label labelBB = new Label("Berat Badan (kg):");
        labelBB.getStyleClass().add("label-form");
        textFieldBB = new TextField();
        textFieldBB.getStyleClass().add("tf-form");

        Label labelTB = new Label("Tinggi Badan (cm):");
        labelTB.getStyleClass().add("label-form");
        textFieldTB = new TextField();
        textFieldTB.getStyleClass().add("tf-form");

        Label labelGender = new Label("Jenis Kelamin:");
        labelGender.getStyleClass().add("label-form");
        boxGender = new ComboBox<>();
        boxGender.getItems().addAll("Perempuan","Laki-Laki");
        boxGender.setValue("Perempuan");
        boxGender.setPrefWidth(150);
        boxGender.setPrefHeight(30);

        Label labelAktivitas = new Label("Tingkat Aktivitas:");
        labelAktivitas.getStyleClass().add("label-form");
        boxAktivitas = new ComboBox<>();
        boxAktivitas.getItems().addAll("Kurang Aktif", "Cukup Aktif","Aktif", "Sangat Aktif"); 
        boxAktivitas.setValue("Kurang Aktif");
        boxAktivitas.setPrefWidth(150);
        boxAktivitas.setPrefHeight(30);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(40);
        gridPane.setPrefWidth(500);
        gridPane.setPrefHeight(500);
        gridPane.add(labelNama, 0, 0);
        gridPane.add(textFieldNama, 0, 1);
        gridPane.add(labelUsia, 1, 0);
        gridPane.add(textFieldUsia, 1, 1);
        gridPane.add(labelBB, 0, 2);
        gridPane.add(textFieldBB, 0, 3);
        gridPane.add(labelTB, 1, 2);
        gridPane.add(textFieldTB, 1, 3);
        gridPane.add(labelGender, 0, 4);
        gridPane.add(boxGender, 0, 5);
        gridPane.add(labelAktivitas, 1, 4);
        gridPane.add(boxAktivitas, 1, 5);
        UIUtil.setupGridPaneLayout(gridPane, 50, 85, 360, 175);

        Button buttonHitungAKG = new Button("Hitung AKG");
        buttonHitungAKG.getStyleClass().add("button-akg");
        UIUtil.setupButtonLayout(buttonHitungAKG, 130, 285, 200, 10);

        labelHasil = new Label();
        labelHasil.getStyleClass().add("label-ket-akg");
        UIUtil.setupLabelLayout(labelHasil, 68, 320, 325, 26);

        hasilHitungAKG = new Label();
        hasilHitungAKG.getStyleClass().add("label-hasil-akg");
        UIUtil.setupLabelLayout(hasilHitungAKG, 138, 345, 184, 26);

        labelNut1 = new Label();
        labelNut1.getStyleClass().add("label-nutrisi");
        UIUtil.setupLabelLayout(labelNut1, 57, 370, 347, 20);

        labelNut2 = new Label();
        labelNut2.getStyleClass().add("label-nutrisi");
        UIUtil.setupLabelLayout(labelNut2, 100, 385, 263, 20);

        labelStatus = new Label();
        labelStatus.getStyleClass().add("label-status");
        UIUtil.setupLabelLayout(labelStatus, 125, 426, 200, 20);

        buttonSimpan = new Button("Simpan Hasil AKG");
        buttonSimpan.getStyleClass().add("button-simpan");
        UIUtil.setupButtonLayout(buttonSimpan, 130, 410, 200, 25);
        buttonSimpan.setVisible(false);

        Label labelHead1 = new Label("Apa Itu AKG?");
        labelHead1.getStyleClass().add("label-header");
        UIUtil.setupLabelLayout(labelHead1, 490,30, 135, 17);
        
        Label labelKet1 = new Label("Angka Kebutuhan Gizi (AKG) adalah\npanduan jumlah     nutrisi harian yang\ndiperlukan untuk menjaga kesehatan\ndan mencegah penyakit, yang diukur\ndalam satuan kalori. Penyusun utama\nkalori ini adalah makronutrien seperti\n karbohidrat, protein, dan lemak.\nKebutuhan ini bervariasi berdasarkan\nusia, jenis kelamin, berat badan, tinggi\nbadan, dan tingkat aktivitas fisik.");
        labelKet1.getStyleClass().add("label-pengertian");
        UIUtil.setupLabelLayout(labelKet1, 490, 50, 230, 170);

        Label labelHead2 = new Label("*Tingkat aktivitas yang harus dipilih\n berdasarkan kegiatan sehari-hari:");
        labelHead2.getStyleClass().add("label-header");
        UIUtil.setupLabelLayout(labelHead2, 490, 270, 230, 40);

        Label labelKet2 = new Label("\r\n" + 
                        "- Kurang Aktif: Kerja kantoran, sedikit\npekerjaan rumah.\r\n" + 
                        "- Cukup Aktif: Kegiatan sehari-hari,\npekerjaan rumah, latihan ringan.\r\n" + 
                        "- Aktif: Kerja fisik ringan, olahraga\nringan rutin.\r\n" + 
                        "- Sangat Aktif: Kerja fisik berat,\nolahraga berat rutin.");
        labelKet2.getStyleClass().add("label-pengertian");
        UIUtil.setupLabelLayout(labelKet2, 490, 300, 200, 150);
        
        UserProfile userProfile = new UserProfile();

        buttonHitungAKG.setOnAction(e -> { hitungAKG(userProfile); });
        buttonSimpan.setOnAction(s -> { simpanAKG(userProfile); });

        root.getChildren().addAll(labelTittle, gridPane, buttonHitungAKG, labelHasil, hasilHitungAKG,
        labelNut1, labelNut2, buttonSimpan, labelStatus, labelHead1, labelKet1, labelHead2, labelKet2);
        
        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/akgc-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        fillFieldsIfUserExists();
    }

    private void fillFieldsIfUserExists() {
        String username = SessionUtil.getUsername();
        if (username != null) {
            try {
                int user_id = UsersController.getUserIdByUsername(username);
                if (user_id != -1 && UserProfileController.isExistingProfile(user_id)) {
                    UserProfile userProfile = UserProfileController.getProfileByUserId(user_id);
                    textFieldNama.setText(userProfile.getName());
                    textFieldUsia.setText(String.valueOf(userProfile.getAge()));
                    textFieldBB.setText(String.valueOf(userProfile.getWeight()));
                    textFieldTB.setText(String.valueOf(userProfile.getHeight()));
                    boxGender.setValue(userProfile.getGender());
                    boxAktivitas.setValue(userProfile.getActivityLevel());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void hitungAKG(UserProfile userProfile) {
        try {
            double akg;
            int usia = Integer.parseInt(textFieldUsia.getText());
            int tb = Integer.parseInt(textFieldTB.getText());
            int bb = Integer.parseInt(textFieldBB.getText());

            if (usia <= 0 || tb <= 0 || bb <= 0) {
                throw new NumberFormatException("Inputan tidak boleh negatif");
            }

            String gender = boxGender.getValue();
            String aktivitas = boxAktivitas.getValue();

            if (gender.equals("Perempuan")) {
                akg = (10 * bb) + (6.25 * tb) - (5 * usia) + 139;
            } else {
                akg = (10 * bb) + (6.25 * tb) - (5 * usia) + 305;
            }

            if (aktivitas.equals("Kurang Aktif")) {
                akg *= 1.2;
            } else if (aktivitas.equals("Cukup Aktif")) {
                akg *= 1.375;
            } else if (aktivitas.equals("Aktif")) {
                akg *= 1.55;
            } else if (aktivitas.equals("Sangat Aktif")) {
                akg *= 1.725;
            }

            double protein = (15.0 / 100 * akg) / 4;
            double lemak = (20.0 / 100 * akg) / 9;
            double karbo = (65.0 / 100 * akg) / 4;

            String sprotein = String.format("%.2f", protein) + "g Protein, ";
            String slemak = String.format("%.2f", lemak) + "g Lemak";
            String skarbo = String.format("%.2f", karbo) + "g Karbohidrat";

            int hasilAKG = (int) akg;
            labelHasil.setText("Angka Kecukupan Gizi Anda adalah:");
            hasilHitungAKG.setText(hasilAKG + " Kalori");
            labelNut1.setText("Anda membutuhkan sekitar " + sprotein + slemak);
            labelNut2.setText("dan " + skarbo);
            buttonSimpan.setVisible(true);
            userProfile.setName(textFieldNama.getText());
            userProfile.setHeight(tb);
            userProfile.setWeight(bb);
            userProfile.setAge(usia);
            userProfile.setGender(gender);
            userProfile.setActivityLevel(aktivitas);
            userProfile.setCalorieNeeds(hasilAKG);
            userProfile.setProteinNeeds(protein);
            userProfile.setFatNeeds(lemak);
            userProfile.setCarboNeeds(karbo);
        } catch (NumberFormatException ex) {
            labelHasil.setText("Input tidak valid.");
        }
    }

    private void simpanAKG(UserProfile userProfile) {
        try {
            String username = SessionUtil.getUsername();
            if (username != null) {
                try {
                    int user_id = UsersController.getUserIdByUsername(username);
                    if (user_id != -1) {
                        boolean isSuccessfull;
                        if (UserProfileController.isExistingProfile(user_id)) {
                            isSuccessfull = UserProfileController.updateProfile(
                                user_id,
                                userProfile.getName(),
                                userProfile.getHeight(),
                                userProfile.getWeight(),
                                userProfile.getAge(),
                                userProfile.getGender(),
                                userProfile.getActivityLevel(),
                                userProfile.getCalorieNeeds(),
                                userProfile.getProteinNeeds(),
                                userProfile.getFatNeeds(),
                                userProfile.getCarboNeeds()
                            );
                        } else {
                            isSuccessfull = UserProfileController.addProfile(
                                user_id,
                                userProfile.getName(),
                                userProfile.getHeight(),
                                userProfile.getWeight(),
                                userProfile.getAge(),
                                userProfile.getGender(),
                                userProfile.getActivityLevel(),
                                userProfile.getCalorieNeeds(),
                                userProfile.getProteinNeeds(),
                                userProfile.getFatNeeds(),
                                userProfile.getCarboNeeds()
                            );
                        }
                        if (isSuccessfull) {
                            ProfileScene profileScene = new ProfileScene(stage);
                            profileScene.show(user_id);
                        } else {
                            labelStatus.setText("Gagal menyimpan data!"); 
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}