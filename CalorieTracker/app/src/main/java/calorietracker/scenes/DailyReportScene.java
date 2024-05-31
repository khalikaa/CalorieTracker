package calorietracker.scenes;

import calorietracker.controllers.SelectedFoodController;
import calorietracker.controllers.UserProfileController;
import calorietracker.models.SelectedFood;
import calorietracker.models.UserProfile;
import calorietracker.util.UIUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.List;

public class DailyReportScene {
    private Stage stage;
    private Label labelKalori;
    private Label labelNutrisi;
    private Label labelStatus;
    
    public DailyReportScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int user_id) {
        Pane root = new Pane();
        BackgroundImage backgroundImage = UIUtil.createBackgroundImage("/images/report_scene.png", 750, 500);
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        UserProfile userProfile = UserProfileController.getProfileByUserId(user_id);

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
        TableColumn<SelectedFood, String> kolomHapus = new TableColumn<>("Hapus");

        kolomNama.setPrefWidth(150);
        kolomEnergi.setPrefWidth(70);
        kolomProtein.setPrefWidth(70);
        kolomLemak.setPrefWidth(70);
        kolomKarbo.setPrefWidth(70);
        kolomBerat.setPrefWidth(70);
        kolomHapus.setPrefWidth(70);

        kolomNama.setCellValueFactory(new PropertyValueFactory<>("name"));
        kolomEnergi.setCellValueFactory(new PropertyValueFactory<>("energy"));
        kolomProtein.setCellValueFactory(new PropertyValueFactory<>("protein"));
        kolomLemak.setCellValueFactory(new PropertyValueFactory<>("fat"));
        kolomKarbo.setCellValueFactory(new PropertyValueFactory<>("carbohydrate"));
        kolomBerat.setCellValueFactory(new PropertyValueFactory<>("weight"));
        kolomHapus.setCellFactory(new Callback<TableColumn<SelectedFood, String>, TableCell<SelectedFood, String>>() {
            @Override
            public TableCell<SelectedFood, String> call(TableColumn<SelectedFood, String> param) {
                return new TableCell<SelectedFood, String>() {
                    Button buttonHapus = new Button("Hapus");

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            buttonHapus.setOnAction(event -> {
                                SelectedFood selectedFood = getTableView().getItems().get(getIndex());
                                foods.remove(selectedFood);
                                updateTotalLabels(labelKalori, labelNutrisi, labelStatus, foods, userProfile);
                            });
                            setGraphic(buttonHapus);
                            setText(null);
                        }
                    }
                };
            }
        });
        selectedFoodsTableView.getColumns().addAll(kolomNama, kolomEnergi, kolomProtein, kolomLemak, kolomKarbo, kolomBerat, kolomHapus);

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

        Button buttonReset = new Button("RESET");
        buttonReset.getStyleClass().add("button-reset");
        UIUtil.setupButtonLayout(buttonReset, 475, 392, 200, 40);

        Button buttonProfil = new Button("PROFIL SAYA");
        buttonProfil.getStyleClass().add("button-profilsaya");
        UIUtil.setupButtonLayout(buttonProfil, 0, 450, 375, 50);
        
        Button buttonLaporan = new Button("LAPORAN HARIAN");
        buttonLaporan.getStyleClass().add("button-laporan");
        UIUtil.setupButtonLayout(buttonLaporan, 375, 450, 375, 50);

        labelKalori = new Label("0 dari " + userProfile.getCalorieNeeds() + " Kalori Terpenuhi");
        labelKalori.getStyleClass().add("label-kalori");
        UIUtil.setupLabelLayout(labelKalori, 205, 30, 325, 26);

        labelNutrisi = new Label("Protein: 0/78g, Lemak: 0/44g , Karbohidrat: 0/325g");
        labelNutrisi.getStyleClass().add("label-nutrisi");
        UIUtil.setupLabelLayout(labelNutrisi, 70, 60, 600, 26);

        labelStatus = new Label();
        labelStatus.getStyleClass().add("label-status");
        UIUtil.setupLabelLayout(labelStatus, 250, 83, 250, 26);

        updateTotalLabels(labelKalori, labelNutrisi, labelStatus, foods, userProfile);

        root.getChildren().addAll(selectedFoodsTableView, buttonProfil, buttonLaporan,
        buttonTambah, buttonReset, labelKalori, labelNutrisi, labelStatus);

        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/report-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private void updateTotalLabels(Label labelKalori, Label labelNutrisi, Label labelStatus, ObservableList<SelectedFood> data, UserProfile userProfile) {
        int totalKalori = data.stream().mapToInt(SelectedFood::getEnergy).sum();
        double totalProtein = data.stream().mapToDouble(SelectedFood::getProtein).sum();
        double totalFat = data.stream().mapToDouble(SelectedFood::getFat).sum();
        double totalCarb = data.stream().mapToDouble(SelectedFood::getCarbohydrate).sum();

        if (totalKalori > userProfile.getCalorieNeeds()) {
            labelStatus.setText("Asupan kalori melebihi batas!");
        } 

        String proteinNeeds = "Protein: " + totalProtein + "/" + String.format("%.2f", userProfile.getProteinNeeds()) + "g, ";
        String fatNeeds = "Lemak: " + totalFat + "/" + String.format("%.2f", userProfile.getFatNeeds()) + "g, "; 
        String carbNeeds = "Karbohidrat: " + totalCarb + "/" + String.format("%.2f", userProfile.getCarboNeeds()) + "g";

        labelKalori.setText(totalKalori + " dari " + userProfile.getCalorieNeeds() + " Kalori Terpenuhi");
        labelNutrisi.setText(proteinNeeds + fatNeeds + carbNeeds);
    }
}