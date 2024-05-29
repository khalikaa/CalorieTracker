package calorietracker.scenes;

import java.util.List;
import java.util.stream.Collectors;

import calorietracker.controllers.NutriInfoController;
import calorietracker.models.NutriInfo;
//import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AddFoodScene {
    private Stage stage;

    private static class Counter {
        int value = 0;
    }
    
    public AddFoodScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Counter selectedFood = new Counter();
        List <NutriInfo> foodsData = NutriInfoController.getAllFood();

        ObservableList <NutriInfo> foods = FXCollections.observableArrayList();
        foods.addAll(foodsData);
        
        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Cari Makanan");

        Button searchButton = new Button("Cari");
        searchButton.setOnAction(e -> {
            String searchText = searchTextField.getText().toLowerCase();
            List<NutriInfo> filteredList = foodsData.stream()
                .filter(food -> food.getNama().toLowerCase().contains(searchText))
                .collect(Collectors.toList());
            foods.setAll(filteredList);
        });

        HBox searchBox = new HBox(10, searchTextField, searchButton);

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
                                //NutriInfo nutriInfo = getTableView().getItems().get(getIndex());
                                selectedFood.value++;
                                statusLabel.setText(selectedFood.value + " item dipilih");
                            });
                            setGraphic(buttonTambah);
                            setText(null);
                        }
                    }
                };
            }
        });
        
        foodsTableView.getColumns().addAll(kolomNama, kolomEnergi, kolomProtein, kolomLemak, kolomKarbo, kolomBerat, kolomTambah);

        foodsTableView.setItems(foods);

        Button saveButton = new Button("Simpan");
        saveButton.setOnAction(e -> {
            DailyReportsScene dailyReportsScene = new DailyReportsScene(stage);
            dailyReportsScene.show();
        });

        VBox root = new VBox(searchBox, foodsTableView, statusLabel, saveButton);
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setPrefWidth(600);

        Scene scene = new Scene(root, 750, 500);
        stage.setScene(scene);
        stage.show();
    }    
}