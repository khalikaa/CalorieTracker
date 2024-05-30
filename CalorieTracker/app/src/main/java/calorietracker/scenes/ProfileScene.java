package calorietracker.scenes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProfileScene extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Angka Kecukupan Gizi Saya");

        // Background Image
        Image image = new Image(getClass().getResourceAsStream("/images/latarpolos.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(750);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(false);

        // Header
        Label headerLabel = new Label("Angka Kecukupan Gizi Saya");
        headerLabel.setFont(new Font("Arial", 24));
        headerLabel.setTextFill(Color.DARKGREEN);

        // Info Box
        Label akgLabel = new Label("AKG Saat ini: 2000");
        Label namaLabel = new Label("Nama: Mikasa");
        Label usiaLabel = new Label("Usia: 20");
        Label beratBadanLabel = new Label("Berat Badan: 60kg");
        Label tinggiBadanLabel = new Label("Tinggi Badan: 170cm");
        Label genderLabel = new Label("Gender: Perempuan");
        Label tingkatAktivitasLabel = new Label("Tingkat Aktivitas: Sangat Aktif");
        Label kebutuhanProteinLabel = new Label("Kebutuhan Protein: 78g");
        Label kebutuhanLemakLabel = new Label("Kebutuhan Lemak: 44g");
        Label kebutuhanKarbohidratLabel = new Label("Kebutuhan Karbohidrat: 325g");

        // Button within the info box
        Button hitungUlangButton = new Button("Hitung Ulang AKG");
        hitungUlangButton.setStyle("-fx-background-color: #90EE90;");

        VBox infoBox = new VBox(10, akgLabel, namaLabel, usiaLabel, beratBadanLabel, tinggiBadanLabel, 
                                    genderLabel, tingkatAktivitasLabel, kebutuhanProteinLabel, 
                                    kebutuhanLemakLabel, kebutuhanKarbohidratLabel, hitungUlangButton);
        infoBox.setStyle("-fx-padding: 16; -fx-background-color: #f0f0f0; -fx-border-color: darkgreen; -fx-border-width: 1;");

        // Button outside the info box
        Button signOutButton = new Button("Sign Out");
        signOutButton.setStyle("-fx-background-color: #FFC0CB;");
        HBox buttonBox = new HBox(signOutButton);
        buttonBox.setStyle("-fx-alignment: center; -fx-padding: 10;");

        // Bottom Buttons
        Button profilSayaButton = new Button("PROFIL SAYA");
        Button laporanHarianButton = new Button("LAPORAN HARIAN");
        
        HBox bottomBox = new HBox(10, profilSayaButton, laporanHarianButton);
        bottomBox.setStyle("-fx-alignment: center; -fx-background-color: #FFC0CB; -fx-padding: 10;");
        
        // Main Layout
        VBox mainLayout = new VBox(20, headerLabel, infoBox, buttonBox, bottomBox);
        mainLayout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        
        StackPane stackPane = new StackPane(imageView, mainLayout);
        StackPane.setAlignment(imageView, Pos.CENTER);
        
        Scene scene = new Scene(stackPane, 750, 500);
        // scene.getStylesheets().add(getClass().getResource("/styles/laporan.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
