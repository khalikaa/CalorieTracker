package calorietracker.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AKGCountScene {
    private Stage stage;

    public AKGCountScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Image image = new Image(getClass().getResourceAsStream("/images/akg_scene.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(750);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(false);

        Label labeltittle = new Label("Hitung Angka Kecukupan Gizi\n(AKG) Anda:");
        labeltittle.getStyleClass().add("label-tittle");

        Label labelUsia = new Label("Usia:");
        labelUsia.getStyleClass().add("label-form");
        TextField textFieldUsia = new TextField();
        textFieldUsia.getStyleClass().add("tf-form");

        Label labelBB = new Label("Berat Badan (kg):");
        labelBB.getStyleClass().add("label-form");
        TextField textFieldBB = new TextField();
        textFieldBB.getStyleClass().add("tf-form");

        Label labelTB = new Label("Tinggi Badan (cm):");
        labelTB.getStyleClass().add("label-form");
        TextField textFieldTB = new TextField();
        textFieldTB.getStyleClass().add("tf-form");

        Label labelGender = new Label("Jenis Kelamin:");
        labelGender.getStyleClass().add("label-form");

        ComboBox<String> boxGender = new ComboBox<>();
        boxGender.getItems().addAll("Perempuan","Laki-Laki");
        boxGender.setValue("Perempuan");

        Label labelAktivitas = new Label("Tingkat Aktivitas:");
        labelAktivitas.getStyleClass().add("label-form");

        Label labelhasil = new Label("Hasil:");
        labelhasil.getStyleClass().add("label-form");

        ComboBox<String> boxAktivitas = new ComboBox<>();
        boxAktivitas.getItems().addAll("Kurang Aktif", "Cukup Aktif","Aktif", "Sangat Aktif"); 
        boxAktivitas.setValue("Jarang Sekali");


        Button hitungAkg = new Button("Hitung AKG");
        hitungAkg.getStyleClass().add("button-akg");

        Button pindah = new Button("pindah");
        
        pindah.setOnAction(e -> {
            DailyReportsScene dailyReportsScene = new DailyReportsScene(stage);
            dailyReportsScene.show();
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 0, 30, 60));
        gridPane.setVgap(3);
        gridPane.setHgap(10);
        gridPane.setPrefWidth(500);
        gridPane.setPrefHeight(500);
        gridPane.add(labeltittle, 0, 0);
        gridPane.add(labelUsia, 0, 2);
        gridPane.add(textFieldUsia, 0, 3);
        gridPane.add(labelBB, 0, 4);
        gridPane.add(textFieldBB, 0, 5);
        gridPane.add(labelTB, 0, 6);
        gridPane.add(textFieldTB, 0, 7);
        gridPane.add(labelGender, 0, 8);
        gridPane.add(boxGender, 0, 9);
        gridPane.add(labelAktivitas, 0, 11);
        gridPane.add(boxAktivitas, 0, 12);
        gridPane.add(hitungAkg, 0, 17);
        gridPane.add(labelhasil, 0, 20);
        gridPane.add(pindah, 0, 21);

        GridPane gridPaneKet = new GridPane();
        gridPaneKet.setPadding(new Insets(20, 60, 30, 60));
        gridPaneKet.setVgap(3);
        gridPaneKet.setHgap(10);

        HBox hBox = new HBox(gridPane, gridPaneKet);
    
        StackPane stackPane = new StackPane(imageView, hBox);

        VBox root = new VBox(stackPane);
        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/akgc-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}