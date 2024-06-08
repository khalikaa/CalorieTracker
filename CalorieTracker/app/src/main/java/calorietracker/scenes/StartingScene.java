package calorietracker.scenes;

import calorietracker.controllers.UsersController;
import calorietracker.models.User;
import calorietracker.util.SessionUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartingScene {
    private Stage stage;
    private VBox mainLayout;
    private TextField textFieldUsername;
    private PasswordField passwordField;
    private Label labelStatus;

    public StartingScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Image image = new Image(getClass().getResourceAsStream("/images/starting_scene.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(750);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(false);

        Label labelCalorie = new Label("Calorie");
        labelCalorie.getStyleClass().add("label-calorie");

        Label labelTracker = new Label("Tracker");
        labelTracker.getStyleClass().add("label-tracker");

        VBox boxTitle = new VBox(labelCalorie, labelTracker);
        boxTitle.setAlignment(Pos.CENTER);
        VBox.setMargin(boxTitle, new Insets(0, 0, 30, 0));

        textFieldUsername = new TextField();
        textFieldUsername.setPromptText("Username");
        textFieldUsername.getStyleClass().add("tf-username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.getStyleClass().add("tf-password");

        labelStatus = new Label();
        labelStatus.getStyleClass().add("red-label");

        mainLayout = new VBox(11, boxTitle);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(0, 0, 40, 325));

        StackPane stackPane = new StackPane(imageView, mainLayout);
        VBox root = new VBox(stackPane);
        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/starting-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        showLogin();
    }

    private void showLogin() {
        mainLayout.getChildren().removeIf(node -> node != mainLayout.getChildren().get(0));

        Button buttonLogin = new Button("LOG IN");
        buttonLogin.getStyleClass().add("starting-button");

        Label labelRegisterSwitch = new Label("Belum punya akun? Daftar di sini!");
        labelRegisterSwitch.getStyleClass().add("red-label");

        VBox loginLayout = new VBox(11, textFieldUsername, passwordField, labelStatus, buttonLogin, labelRegisterSwitch);
        loginLayout.setAlignment(Pos.CENTER);

        mainLayout.getChildren().add(loginLayout);

        labelRegisterSwitch.setOnMouseClicked(e -> {
            showRegister();
            textFieldUsername.setText("");
            passwordField.setText("");
        });

        buttonLogin.setOnAction(e -> {
            String username = textFieldUsername.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                labelStatus.setText("Email dan password harus diisi!");
                return;
            }
            User user = UsersController.login(username, password);
            if (user != null) {
                SessionUtil.setUsername(username);
                int user_id = UsersController.getUserIdByUsername(username);
                if (user_id != -1) {
                    ProfileScene profileScene = new ProfileScene(stage); 
                    profileScene.show(user_id);
                }
            } else {
                labelStatus.setText("Email atau password salah!");
            }
        });
    }

    private void showRegister() {
        mainLayout.getChildren().removeIf(node -> node != mainLayout.getChildren().get(0));

        Button buttonSignup = new Button("SIGN UP");
        buttonSignup.getStyleClass().add("starting-button");

        Label labelLoginSwitch = new Label("Sudah punya akun? Masuk di sini!");
        labelLoginSwitch.getStyleClass().add("red-label");

        VBox registerLayout = new VBox(11, textFieldUsername, passwordField, labelStatus, buttonSignup, labelLoginSwitch);
        registerLayout.setAlignment(Pos.CENTER);

        mainLayout.getChildren().add(registerLayout);

        labelLoginSwitch.setOnMouseClicked(e -> {
            showLogin();
            textFieldUsername.setText("");
            passwordField.setText("");           
        });

        buttonSignup.setOnAction(e -> {
            String username = textFieldUsername.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                labelStatus.setText("Data tidak boleh kosong!");
                return;
            }
            boolean isSuccessfullRegister = UsersController.register(username, password);
            if (isSuccessfullRegister) {
                SessionUtil.setUsername(username);
                AKGCountScene akgCountScene = new AKGCountScene(stage);
                akgCountScene.show();
            } else {
                labelStatus.setText("Gagal mendaftar. Username tidak tersedia!");
            }
        });
    }
}