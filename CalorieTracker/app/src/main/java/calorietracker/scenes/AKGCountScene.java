package calorietracker.scenes;

import calorietracker.util.UIUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
        Pane root = new Pane();
        BackgroundImage backgroundImage = UIUtil.createBackgroundImage("/images/sceneakg.png", 750, 500);
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        Label labeltittle = new Label("Hitung Angka Kecukupan Gizi\n(AKG) Anda:");
        labeltittle.getStyleClass().add("label-tittle");

        Label labelNama = new Label("Nama:");
        labelNama.getStyleClass().add("label-form");
        TextField textFieldNama = new TextField();
        textFieldNama.getStyleClass().add("tf-form");

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
        boxGender.setPrefWidth(150);
        boxGender.setPrefHeight(30);

        Label labelAktivitas = new Label("Tingkat Aktivitas:");
        labelAktivitas.getStyleClass().add("label-form");

        Label labelhasil = new Label("Hasil:");
        labelhasil.getStyleClass().add("label-form");


        ComboBox<String> boxAktivitas = new ComboBox<>();
        boxAktivitas.getItems().addAll("Kurang Aktif", "Cukup Aktif","Aktif", "Sangat Aktif"); 
        boxAktivitas.setValue("Jarang Sekali");
        boxAktivitas.setPrefWidth(150);
        boxAktivitas.setPrefHeight(30);

        Button hitungAkg = new Button("Hitung AKG");
        hitungAkg.getStyleClass().add("button-akg");
        UIUtil.setupButtonLayout(hitungAkg, 110, 270, 300, 25);

        Button simpanhasil = new Button("Simpan Hasil AKG");
        simpanhasil.getStyleClass().add("button-hasilakg");
        UIUtil.setupButtonLayout(simpanhasil, 110, 429, 300, 25);
        simpanhasil.setVisible(false);

        Label hasilhitung = new Label("Angka Kecukupan Gizi Anda adalah:");
        hasilhitung.getStyleClass().add("label-hasil");
        UIUtil.setupLabelLayout(hasilhitung, 115, 320, 325, 26);

        Label labelbutuh = new Label("Anda membutuhkan sekitar 75g Protein,44g Lemak, \ndan 325g Karbohidrat setiap harinya");
        labelbutuh.getStyleClass().add("label-butuh");
        UIUtil.setupLabelLayout(labelbutuh, 115, 380, 301, 34);

        Label hasilhitungakg = new Label("466");
        hasilhitungakg.getStyleClass().add("label-hasilhitungakg");
        UIUtil.setupLabelLayout(hasilhitungakg, 230, 345, 301, 34);

        Label labelapaitu = new Label("Apa Itu AKG?");
        labelapaitu.getStyleClass().add("label-apaitu");
        Pane paneLabelApaItu = new Pane(labelapaitu);
        labelapaitu.setLayoutX(503); // Posisi X
        labelapaitu.setLayoutY(20);  // Posisi Y
        paneLabelApaItu.setPrefSize(750, 500);
        
        Label labelmaksudakg= new Label("Angka Kebutuhan Gizi (AKG) adalah\npanduan jumlah     nutrisi harian yang\ndiperlukan untuk menjaga kesehatan\ndan mencegah penyakit, yang diukur\ndalam satuan kalori. Penyusun utama\nkalori ini adalah makronutrien seperti\n karbohidrat, protein, dan lemak.\nKebutuhan ini bervariasi berdasarkan\nusia, jenis kelamin, berat badan, tinggi\nbadan, dan tingkat aktivitas fisik.");
        labelmaksudakg.getStyleClass().add("label-pengertian");
        Pane paneLabelmaksudakg = new Pane(paneLabelApaItu);
        labelmaksudakg.setLayoutX(503); // Posisi X
        labelmaksudakg.setLayoutY(55);  // Posisi Y
        paneLabelmaksudakg.setPrefSize(750, 500);

        Label labeltingkataktifitas = new Label("*Tingkat aktivitas yang harus dipilih\n berdasarkan kegiatan sehari-hari:");
        labeltingkataktifitas.getStyleClass().add("label-TA");
        Pane panelabeltingkataktifitas = new Pane(labeltingkataktifitas);
        labeltingkataktifitas.setLayoutX(503); // Posisi X
        labeltingkataktifitas.setLayoutY(240);  // Posisi Y
        paneLabelmaksudakg.setPrefSize(750, 500);


        Label labelTA = new Label("\r\n" + //
                        "-Kurang Aktif: Kerja kantoran, sedikit\npekerjaan rumah.\r\n" + //
                        "-Cukup Aktif: Kegiatan sehari-hari,\npekerjaan rumah, latihan ringan.\r\n" + //
                        "-Aktif: Kerja fisik ringan, olahraga\nringan rutin.\r\n" + //
                        "-Sangat Aktif: Kerja fisik berat,\nolahraga berat rutin.");
        labelTA.getStyleClass().add("label-pengertian");
        Pane panelabelTA = new Pane(labeltingkataktifitas);
        labelTA.setLayoutX(503);
        labelTA.setLayoutY(270); 
        panelabelTA.setPrefSize(750, 500);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 0, 30, 60));
        gridPane.setVgap(3);
        gridPane.setHgap(10);
        gridPane.setPrefWidth(500);
        gridPane.setPrefHeight(500);
        gridPane.add(labeltittle, 0, 0);
        gridPane.add(labelNama, 0, 1);
        gridPane.add(textFieldNama, 0, 2);
        gridPane.add(labelUsia, 1, 1);
        gridPane.add(textFieldUsia, 1, 2);
        gridPane.add(labelBB, 0, 3);
        gridPane.add(textFieldBB, 0, 4);
        gridPane.add(labelTB, 1, 3);
        gridPane.add(textFieldTB, 1, 4);
        gridPane.add(labelGender, 0, 5);
        gridPane.add(boxGender, 0, 6);
        gridPane.add(labelAktivitas, 1, 5);
        gridPane.add(boxAktivitas, 1, 6);

        GridPane gridPaneKet = new GridPane();
        gridPaneKet.setPadding(new Insets(20, 60, 30, 60));
        gridPaneKet.setVgap(3);
        gridPaneKet.setHgap(10);

        HBox hBox = new HBox(gridPane, gridPaneKet);
        VBox vBox = new VBox(hBox,hitungAkg, hasilhitung,simpanhasil, labelbutuh,hasilhitungakg, labelapaitu,labelmaksudakg,labeltingkataktifitas, labelTA);

        Button pindah = new Button("pindah");
        

        hitungAkg.setOnAction(e -> {
            simpanhasil.setVisible(true);
        });

        root.getChildren().addAll(gridPane, hitungAkg,hasilhitung,simpanhasil, labelbutuh,hasilhitungakg,labelapaitu,labelmaksudakg,labeltingkataktifitas, labelTA);
        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/akgc-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}

