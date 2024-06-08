package calorietracker;

import calorietracker.scenes.AKGCountScene;
import calorietracker.scenes.SplashScreen;
import calorietracker.scenes.StartingScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Calorie Tracker");
        stage.setResizable(false);
        
        Image imageIcon = new Image(getClass().getResourceAsStream("/images/logo_calorietracker.png"));
        stage.getIcons().add(imageIcon);

        SplashScreen splashScreen = new SplashScreen(stage);
        splashScreen.show();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                stage.close();

                VBox root = new VBox();
                Scene scene = new Scene(root, 750, 500);
                stage.setScene(scene);
                stage.show();
 
                // AKGCountScene a = new AKGCountScene(stage);
                // a.show();
                StartingScene startingScene = new StartingScene(stage);
                startingScene.show();
            });
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}