package calorietracker.scenes;

import calorietracker.controllers.UsersController;
import calorietracker.models.User;
import calorietracker.util.SessionUtil;
import calorietracker.util.UIUtil;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartingScene {
    private Stage stage;
    private TextField textFieldUsername;
    private PasswordField passwordField;
    private Label labelStatus;
    private Pane root;
    private Label labelMark;

    public StartingScene(Stage stage) {
        this.stage = stage;
        this.root = new Pane();
        initializeUI();
    }

    private void initializeUI() {
        BackgroundImage backgroundImage = UIUtil.createBackgroundImage("/images/starting_scene.png", 750, 500);
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        Label labelCalorie = new Label("Calorie");
        labelCalorie.getStyleClass().add("label-calorie");
        UIUtil.setupLabelLayout(labelCalorie, 375, 34, 335, 84);

        Label labelTracker = new Label("Tracker");
        labelTracker.getStyleClass().add("label-tracker");
        UIUtil.setupLabelLayout(labelTracker, 375, 102, 335, 84);

        labelMark = new Label();
        UIUtil.setupLabelLayout(labelMark, 444, 196, 189, 29);

        textFieldUsername = new TextField();
        textFieldUsername.setPromptText("Username");
        UIUtil.setupTextFieldLayout(textFieldUsername, 413, 237, 260, 45);

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        UIUtil.setupPasswordFieldLayout(passwordField, 413, 293, 260, 45);

        labelStatus = new Label();
        labelStatus.getStyleClass().add("red-label");

        root.getChildren().addAll(labelCalorie, labelTracker, labelMark, labelStatus);
    }

    public void show() {
        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/starting-styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        showLogin();
    }

    private void showLogin() {
        clearMainLayout();
        
        // Tambahkan kelas CSS yang sesuai
        textFieldUsername.getStyleClass().setAll("tf-pink");
        passwordField.getStyleClass().setAll("tf-pink");

        labelMark.getStyleClass().setAll("green-mark");
        labelMark.setText("Welcome back!");

        Button buttonLogin = new Button("SIGN IN");
        buttonLogin.getStyleClass().add("signin-button");
        UIUtil.setupButtonLayout(buttonLogin, 413, 384, 259, 44);

        Label labelRegisterSwitch = new Label("Belum punya akun? Daftar di sini!");
        labelRegisterSwitch.getStyleClass().add("red-label");

        VBox loginLayout = new VBox(11, textFieldUsername, passwordField, labelStatus, buttonLogin, labelRegisterSwitch);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setLayoutX(413);
        loginLayout.setLayoutY(237);

        root.getChildren().add(loginLayout);

        labelRegisterSwitch.setOnMouseClicked(e -> {
            showRegister();
            textFieldUsername.setText("");
            passwordField.setText("");
            labelStatus.setText("");
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
        clearMainLayout();

        textFieldUsername.getStyleClass().setAll("tf-green");
        passwordField.getStyleClass().setAll("tf-green");

        labelMark.getStyleClass().setAll("red-mark");
        labelMark.setText("Create new account");

        Button buttonSignup = new Button("SIGN UP");
        buttonSignup.getStyleClass().add("signup-button");
        UIUtil.setupButtonLayout(buttonSignup, 413, 384, 259, 44);

        Label labelLoginSwitch = new Label("Sudah punya akun? Masuk di sini!");
        labelLoginSwitch.getStyleClass().add("red-label");

        VBox registerLayout = new VBox(11, textFieldUsername, passwordField, labelStatus, buttonSignup, labelLoginSwitch);
        registerLayout.setAlignment(Pos.CENTER);
        registerLayout.setLayoutX(413);
        registerLayout.setLayoutY(237);

        root.getChildren().add(registerLayout);

        labelLoginSwitch.setOnMouseClicked(e -> {
            showLogin();
            textFieldUsername.setText("");
            passwordField.setText("");           
            labelStatus.setText("");
        });

        buttonSignup.setOnAction(e -> {
            String username = textFieldUsername.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                labelStatus.setText("Email dan password harus diisi!");
                return;
            }
            boolean isSuccessfullRegister = UsersController.register(username, password);
            if (isSuccessfullRegister) {
                SessionUtil.setUsername(username);
                AKGCountScene akgCountScene = new AKGCountScene(stage);
                akgCountScene.show();
            } else {
                labelStatus.setText("Username tidak tersedia!");
            }
        });
    }

    private void clearMainLayout() {
        root.getChildren().removeIf(node -> node instanceof VBox);
    }
}