package calorietracker.scenes;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplashScreen {
    private Stage stage;

    public SplashScreen(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        Image image = new Image(getClass().getResourceAsStream("/images/splash_screen.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(750);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(false);

        StackPane stackPane = new StackPane(imageView); //, vBoxLoading

        VBox root = new VBox(stackPane);
        Scene scene = new Scene(root, 750, 500);
        stage.setScene(scene);
        stage.show();
    }
}