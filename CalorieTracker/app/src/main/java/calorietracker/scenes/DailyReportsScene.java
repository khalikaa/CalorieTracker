package calorietracker.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DailyReportsScene {
    private Stage stage;

    public DailyReportsScene(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Image image = new Image(getClass().getResourceAsStream("/images/report_scene.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(750);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(false);

        Label labelLaporanKalori = new Label("");
        labelLaporanKalori.getStyleClass().add("label-laporan");

        Button buttonTambah = new Button("TAMBAH MAKANAN");
        buttonTambah.getStyleClass().add("button-tambah");
        buttonTambah.setOnAction(e -> {
            AddFoodScene addFoodScene = new AddFoodScene(stage);
            addFoodScene.show();
        });

        Button buttonCatatanHarian = new Button("CATATAN HARIAN");
        buttonCatatanHarian.getStyleClass().add("button-catatan");

        Button buttonLaporan = new Button("LAPORAN");
        buttonLaporan.getStyleClass().add("button-laporan");

        VBox vBox = new VBox(60, labelLaporanKalori, buttonTambah);
        vBox.setAlignment(Pos.TOP_CENTER); 
        vBox.setStyle("-fx-padding: 20;");

        StackPane stackPane = new StackPane(imageView, vBox);
        StackPane.setAlignment(imageView, Pos.CENTER);

        StackPane.setAlignment(buttonCatatanHarian, Pos.BOTTOM_LEFT);
        buttonCatatanHarian.setStyle("-fx-margin: 20;");
        stackPane.getChildren().add(buttonCatatanHarian);

        StackPane.setAlignment(buttonLaporan, Pos.BOTTOM_RIGHT);
        buttonLaporan.setStyle("-fx-margin: 20;");
        stackPane.getChildren().add(buttonLaporan);

        Scene scene = new Scene(stackPane, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/report-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}

