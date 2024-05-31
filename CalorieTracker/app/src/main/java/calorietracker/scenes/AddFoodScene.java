package calorietracker.scenes;

import java.util.List;
import java.util.stream.Collectors;

import calorietracker.controllers.NutriInfoController;
import calorietracker.controllers.SelectedFoodController;
import calorietracker.models.NutriInfo;
import calorietracker.models.SelectedFood;
import calorietracker.util.UIUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AddFoodScene {
    private Stage stage;
    int value = 0;
    
    public AddFoodScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int user_id) {
        Pane root = new Pane();
        BackgroundImage backgroundImage = UIUtil.createBackgroundImage("/images/search_scene.png", 750, 500);
        Background background = new Background(backgroundImage);
        root.setBackground(background);
        
        Button backButton = new Button("<");
        UIUtil.setupButtonLayout(backButton, 15, 8, 35, 35);
        backButton.getStyleClass().add("back-button");

        List <NutriInfo> foodsData = NutriInfoController.getAllFood();

        ObservableList <NutriInfo> foods = FXCollections.observableArrayList();
        foods.addAll(foodsData);
        
        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Cari Makanan");
        searchTextField.getStyleClass().add("search-tf");
        UIUtil.setupTextFieldLayout(searchTextField, 75, 80, 500, 40);

        Button searchButton = new Button("Cari");
        searchButton.getStyleClass().add("search-button");
        UIUtil.setupButtonLayout(searchButton, 590, 80, 85,40);

        searchButton.setOnAction(e -> {
            String searchText = searchTextField.getText().toLowerCase();
            List<NutriInfo> filteredList = foodsData.stream()
                .filter(food -> food.getNama().toLowerCase().contains(searchText))
                .collect(Collectors.toList());
            foods.setAll(filteredList);
        });

        TableView<NutriInfo> foodsTableView = new TableView<>();
        foodsTableView.setPrefHeight(300);
        foodsTableView.setMaxWidth(605);

        TableColumn<NutriInfo, String> kolomNama = new TableColumn<>("Nama Makanan");
        TableColumn<NutriInfo, String> kolomEnergi = new TableColumn<>("Energi (Kal)");
        TableColumn<NutriInfo, String> kolomProtein = new TableColumn<>("Protein (g)");
        TableColumn<NutriInfo, String> kolomLemak = new TableColumn<>("Lemak (g)");
        TableColumn<NutriInfo, String> kolomKarbo = new TableColumn<>("Karbo (g)");
        TableColumn<NutriInfo, String> kolomBerat = new TableColumn<>("Berat (g)");
        TableColumn<NutriInfo, String> kolomTambah = new TableColumn<>("Tambah");

        kolomNama.setPrefWidth(150);
        kolomEnergi.setPrefWidth(70);
        kolomProtein.setPrefWidth(70);
        kolomLemak.setPrefWidth(70);
        kolomKarbo.setPrefWidth(70);
        kolomBerat.setPrefWidth(70);

        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolomEnergi.setCellValueFactory(new PropertyValueFactory<>("energi"));
        kolomProtein.setCellValueFactory(new PropertyValueFactory<>("protein"));
        kolomLemak.setCellValueFactory(new PropertyValueFactory<>("lemak"));
        kolomKarbo.setCellValueFactory(new PropertyValueFactory<>("karbohidrat"));
        kolomBerat.setCellValueFactory(new PropertyValueFactory<>("berat"));
       
        Label statusLabel = new Label();
        UIUtil.setupLabelLayout(statusLabel, 299, 464, 152, 21);
        statusLabel.getStyleClass().add("label-status");
        
        kolomTambah.setCellFactory(new Callback<TableColumn<NutriInfo, String>, TableCell<NutriInfo, String>>() {
            @Override
            public TableCell<NutriInfo, String> call(TableColumn<NutriInfo, String> param) {
                return new TableCell<NutriInfo, String>() {
                    Button buttonTambah = new Button("Tambah");

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            buttonTambah.setOnAction(event -> {
                                NutriInfo selectedFood = getTableView().getItems().get(getIndex());
                                SelectedFood food = new SelectedFood(user_id,
                                selectedFood.getNama(),
                                selectedFood.getEnergi(),
                                selectedFood.getProtein(),
                                selectedFood.getLemak(),
                                selectedFood.getKarbohidrat(),
                                selectedFood.getBerat());
                                SelectedFoodController.addSelectedFood(user_id, food);
                                value++;
                                statusLabel.setText(value + " item dipilih");
                            });
                            setGraphic(buttonTambah);
                            setText(null);
                        }
                    }
                };
            }
        });

        Button saveButton = new Button("SIMPAN");
        saveButton.getStyleClass().add("save-button");
        UIUtil.setupButtonLayout(saveButton, 600, 0, 150, 52);
        saveButton.setOnAction(e-> {
            DailyReportScene dailyReportScene = new DailyReportScene(stage);
            dailyReportScene.show(user_id);
        });

        foodsTableView.getColumns().addAll(kolomNama, kolomEnergi, kolomProtein, kolomLemak, kolomKarbo, kolomBerat, kolomTambah);
        foodsTableView.setItems(foods);
        foodsTableView.setPrefWidth(600);
        foodsTableView.setPrefHeight(275);
        foodsTableView.setLayoutX(75);
        foodsTableView.setLayoutY(135);

        root.getChildren().addAll(backButton, saveButton, foodsTableView, searchTextField, searchButton, statusLabel);

        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/searching-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }    
}