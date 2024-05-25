package calorietracker.scenes;

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

public class RegisterScene {
    private Stage stage;

    public RegisterScene(Stage stage) {
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

        TextField textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Email");
        textFieldEmail.getStyleClass().add("tf-email");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.getStyleClass().add("tf-password");
        
        Label labelStatus = new Label();
        labelStatus.getStyleClass().add("red-label");

        Button buttonSignup = new Button("SIGN UP");
        buttonSignup.getStyleClass().add("starting-button");

        Label labelLogIn = new Label("Sudah punya akun? Masuk di sini!");
        labelLogIn.getStyleClass().add("red-label");

        VBox mainLayout = new VBox(11, boxTitle, textFieldEmail, passwordField, labelStatus, buttonSignup, labelLogIn);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(0, 0, 40, 325));
        
        StackPane stackPane = new StackPane(imageView, mainLayout);
        
        VBox root = new VBox(stackPane);
        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        buttonSignup.setOnAction(e -> {
            String email = textFieldEmail.getText();
            String password = passwordField.getText();
            if (email.isEmpty() || password.isEmpty()){
                labelStatus.setText("Email dan password harus diisi!");
                return;
            }
        });

        labelLogIn.setOnMouseClicked(e -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
        });
    }
}