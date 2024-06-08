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
        selectedFoodsTableView.setItems(foods);
        selectedFoodsTableView.setLayoutX(75);
        selectedFoodsTableView.setLayoutY(113);
        selectedFoodsTableView.setPrefWidth(600);
        selectedFoodsTableView.setPrefHeight(260);

        TableColumn<SelectedFood, String> kolomNama = new TableColumn<>("Nama Makanan");
        TableColumn<SelectedFood, Integer> kolomEnergi = new TableColumn<>("Energi (Kal)");
        TableColumn<SelectedFood, Double> kolomProtein = new TableColumn<>("Protein (g)");
        TableColumn<SelectedFood, Double> kolomLemak = new TableColumn<>("Lemak (g)");
        TableColumn<SelectedFood, Double> kolomKarbo = new TableColumn<>("Karbo (g)");
        TableColumn<SelectedFood, Integer> kolomBerat = new TableColumn<>("Berat (g)");
        TableColumn<SelectedFood, Void> kolomHapus = new TableColumn<>("Hapus");

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
        kolomHapus.setCellFactory(new Callback<TableColumn<SelectedFood, Void>, TableCell<SelectedFood, Void>>() {
            @Override
            public TableCell<SelectedFood, Void> call(TableColumn<SelectedFood, Void> param) {
                return new TableCell<SelectedFood, Void>() {
                    Button buttonHapus = new Button("Hapus");

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            buttonHapus.setOnAction(event -> {
                                SelectedFood selectedFood = getTableView().getItems().get(getIndex());
                                SelectedFoodController.deleteSelectedFood(selectedFood.getId());
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

        Button buttonTambah = new Button("+ TAMBAH MAKANAN");
        buttonTambah.getStyleClass().add("button-tambah");
        UIUtil.setupButtonLayout(buttonTambah, 75, 392, 380, 40);
        buttonTambah.setOnAction(e -> {
            AddFoodScene addFoodScene = new AddFoodScene(stage);
            addFoodScene.show(user_id);
        });

        Button buttonReset = new Button("RESET");
        buttonReset.getStyleClass().add("button-reset");
        UIUtil.setupButtonLayout(buttonReset, 475, 392, 200, 40);
        buttonReset.setOnAction(e -> {
            SelectedFoodController.deleteAllSelectedFoodsByUserId(user_id);
            foods.clear();
            updateTotalLabels(labelKalori, labelNutrisi, labelStatus, foods, userProfile);
        });

        Label labelProfil = new Label("PROFIL SAYA");
        labelProfil.getStyleClass().add("label-profil");
        UIUtil.setupLabelLayout(labelProfil, 0, 450, 375, 50);
        labelProfil.setOnMouseClicked(e -> {
            ProfileScene profileScene = new ProfileScene(stage);
            profileScene.show(user_id);
        });

        Label labelLaporan = new Label("LAPORAN HARIAN");
        labelLaporan.getStyleClass().add("label-laporan");
        UIUtil.setupLabelLayout(labelLaporan, 375, 450, 375, 50);

        labelKalori = new Label("0 dari " + userProfile.getCalorieNeeds() + " Kalori Terpenuhi");
        labelKalori.getStyleClass().add("label-kalori");
        UIUtil.setupLabelLayout(labelKalori, 185, 25, 380, 26);

        labelNutrisi = new Label("Protein: 0/78g, Lemak: 0/44g , Karbohidrat: 0/325g");
        labelNutrisi.getStyleClass().add("label-nutrisi");
        UIUtil.setupLabelLayout(labelNutrisi, 75, 55, 600, 26);

        labelStatus = new Label();
        labelStatus.getStyleClass().add("label-status");
        UIUtil.setupLabelLayout(labelStatus, 250, 78, 250, 26);

        updateTotalLabels(labelKalori, labelNutrisi, labelStatus, foods, userProfile);

        root.getChildren().addAll(selectedFoodsTableView, labelProfil, labelLaporan, 
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
        } else {
            labelStatus.setText("");
        }

        String proteinNeeds = "Protein: " + totalProtein + "/" + String.format("%.2f", userProfile.getProteinNeeds()) + "g, ";
        String fatNeeds = "Lemak: " + totalFat + "/" + String.format("%.2f", userProfile.getFatNeeds()) + "g, "; 
        String carbNeeds = "Karbohidrat: " + totalCarb + "/" + String.format("%.2f", userProfile.getCarboNeeds()) + "g";

        labelKalori.setText(totalKalori + " dari " + userProfile.getCalorieNeeds() + " Kalori Terpenuhi");
        labelNutrisi.setText(proteinNeeds + fatNeeds + carbNeeds);
    }
}