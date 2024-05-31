package calorietracker.scenes;

import calorietracker.controllers.SelectedFoodController;
import calorietracker.models.SelectedFood;
import calorietracker.util.UIUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.List;

public class DailyReportScene {
    private Stage stage;
    
    public DailyReportScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int user_id) {
        Pane root = new Pane();
        BackgroundImage backgroundImage = UIUtil.createBackgroundImage("/images/report_scene.png", 750, 500);
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        List<SelectedFood> selectedFoods = SelectedFoodController.getSelectedFoods(user_id);
        
        ObservableList<SelectedFood> foods = FXCollections.observableArrayList();
        foods.addAll(selectedFoods);

        TableView<SelectedFood> selectedFoodsTableView = new TableView<>();
        selectedFoodsTableView.setPrefWidth(600);
        selectedFoodsTableView.setPrefHeight(400);
        selectedFoodsTableView.setLayoutX(75);
        selectedFoodsTableView.setLayoutY(50);

        TableColumn<SelectedFood, String> kolomNama = new TableColumn<>("Nama Makanan");
        TableColumn<SelectedFood, String> kolomEnergi = new TableColumn<>("Energi (Kal)");
        TableColumn<SelectedFood, String> kolomProtein = new TableColumn<>("Protein (g)");
        TableColumn<SelectedFood, String> kolomLemak = new TableColumn<>("Lemak (g)");
        TableColumn<SelectedFood, String> kolomKarbo = new TableColumn<>("Karbo (g)");
        TableColumn<SelectedFood, String> kolomBerat = new TableColumn<>("Berat (g)");

        kolomNama.setPrefWidth(150);
        kolomEnergi.setPrefWidth(70);
        kolomProtein.setPrefWidth(70);
        kolomLemak.setPrefWidth(70);
        kolomKarbo.setPrefWidth(70);
        kolomBerat.setPrefWidth(70);

        kolomNama.setCellValueFactory(new PropertyValueFactory<>("name"));
        kolomEnergi.setCellValueFactory(new PropertyValueFactory<>("energy"));
        kolomProtein.setCellValueFactory(new PropertyValueFactory<>("protein"));
        kolomLemak.setCellValueFactory(new PropertyValueFactory<>("fat"));
        kolomKarbo.setCellValueFactory(new PropertyValueFactory<>("carbohydrate"));
        kolomBerat.setCellValueFactory(new PropertyValueFactory<>("weight"));

        selectedFoodsTableView.getColumns().addAll(kolomNama, kolomEnergi, kolomProtein, kolomLemak, kolomKarbo, kolomBerat);

        selectedFoodsTableView.setItems(foods);
        selectedFoodsTableView.setLayoutX(75);
        selectedFoodsTableView.setLayoutY(113);
        selectedFoodsTableView.setPrefWidth(600);
        selectedFoodsTableView.setPrefHeight(261);

        Button buttonTambah = new Button("+ TAMBAH MAKANAN");
        buttonTambah.getStyleClass().add("button-tambah");
        UIUtil.setupButtonLayout(buttonTambah, 66, 392, 400, 40);
        buttonTambah.setOnAction(e -> {
            AddFoodScene addFoodScene = new AddFoodScene(stage);
            addFoodScene.show(user_id);
        });

        Button buttonReset = new Button("Reset");
        buttonReset.getStyleClass().add("button-reset");
        UIUtil.setupButtonLayout(buttonReset, 475, 392, 200, 40);

        Button buttonProfil = new Button("PROFIL SAYA");
        buttonProfil.getStyleClass().add("button-profilsaya");
        UIUtil.setupButtonLayout(buttonProfil, 0, 450, 375, 50);
        
        Button buttonLaporan = new Button("LAPORAN HARIAN");
        buttonLaporan.getStyleClass().add("button-laporan");
        UIUtil.setupButtonLayout(buttonLaporan, 375, 450, 375, 50);

        Label labelKaloriTerpenuhi = new Label("1800 dari 2000 Kalori terpenuhi");
        labelKaloriTerpenuhi.getStyleClass().add("label-kaloriTerpenuhi");
        UIUtil.setupLabelLayout(labelKaloriTerpenuhi, 250, 31, 325, 26);

        Label labelNutrisi = new Label("Protein: 50/78g, Lemak: 30/44g , Karbohidrat: 200/325g");
        labelNutrisi.getStyleClass().add("label-nutrisi");
        UIUtil.setupLabelLayout(labelNutrisi, 156, 65, 438, 26);

        root.getChildren().addAll(selectedFoodsTableView, buttonProfil, buttonLaporan, buttonTambah, buttonReset, labelKaloriTerpenuhi, labelNutrisi);

        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/report-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}