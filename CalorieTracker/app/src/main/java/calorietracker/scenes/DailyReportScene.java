package calorietracker.scenes;

import calorietracker.controllers.SelectedFoodController;
import calorietracker.models.SelectedFood;
import calorietracker.util.UIUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        Button buttonTambah = new Button("TAMBAH MAKANAN");
        buttonTambah.getStyleClass().add("button-tambah");
        buttonTambah.setOnAction(e -> {
            AddFoodScene addFoodScene = new AddFoodScene(stage);
            addFoodScene.show(user_id);
        });

        Button buttonProfil = new Button("PROFIL SAYA");
        buttonProfil.getStyleClass().add("button-catatan");

        Button buttonLaporan = new Button("LAPORAN HARIAN");
        buttonLaporan.getStyleClass().add("button-laporan");

        root.getChildren().addAll(selectedFoodsTableView, buttonProfil, buttonLaporan, buttonTambah);

        Scene scene = new Scene(root, 750, 500);
        stage.setScene(scene);
        stage.show();
    }
}