package calorietracker.util;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class UIUtil {
    public static BackgroundImage createBackgroundImage(String imagePath, double width, double height) {
        Image image = new Image(imagePath, width, height, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(
            image,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT
        );
        return backgroundImage;
    }
    
    public static void setupButtonLayout(Button button, double x, double y, double width, double height) {
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefWidth(width);
        button.setPrefHeight(height);
    }

    public static void setupLabelLayout(Label label, double x, double y, double width, double height) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setPrefWidth(width);
        label.setPrefHeight(height);
    }

    public static void setupTextFieldLayout(TextField textField, double x, double y, double width, double height) {
        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setPrefWidth(width);
        textField.setPrefHeight(height);
    }

    public static void setupVBoxLayout(VBox vb, double x, double y, double width, double height) {
        vb.setLayoutX(x);
        vb.setLayoutY(y);
        vb.setPrefWidth(width);
        vb.setPrefHeight(height);
    }

    public static void setupGridPaneLayout(GridPane gridPane, double x, double y, double width, double height) {
        gridPane.setLayoutX(x);
        gridPane.setLayoutY(y);
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
    }
}