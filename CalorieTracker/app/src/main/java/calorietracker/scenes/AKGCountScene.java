package calorietracker.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AKGCountScene {
    private Stage stage;

    public AKGCountScene(Stage stage) {
        this.stage = stage;
    }

    public void show(){
        // Image image = new Image(getClass().getResourceAsStream("/images/starting_scene.png"));
        // ImageView imageView = new ImageView(image);
        // imageView.setFitWidth(750);
        // imageView.setFitHeight(500);
        // imageView.setPreserveRatio(false);

        Label labelUsia = new Label("Usia:");
        TextField textFieldUsia = new TextField();

        Label labelNama = new Label("Nama:");
        TextField textFieldNama = new TextField();

        Label labelBB = new Label("Berat Badan:");
        TextField textBB = new TextField();

        Label labelTB = new Label("Tinggi Badan");
        TextField textTB = new TextField();

        Label labelTujuan = new Label("Tujuan Diet:");
        Label labelGender = new Label("Jenis Kelamin:");
        Label labelAktivitas = new Label("Tingkat Aktivitas:");
        
        Button hitungAKG = new Button("Hitung AKG");

        ComboBox<String> boxTujuan = new ComboBox<>();
        boxTujuan.getItems().addAll("Pertahankan berat badan");
        boxTujuan.getItems().addAll("Peningkatan berat badan");
        boxTujuan.getItems().addAll("Pengurangan berat badan");
        boxTujuan.setValue("Pertahankan berat badan"); // Default value

        ComboBox<String> boxGender = new ComboBox<>();
        boxGender.getItems().addAll("Perempuan");
        boxGender.getItems().addAll("Laki-Laki");
        boxGender.setValue("Perempuan"); // Default value

        ComboBox<String> boxAktivitas = new ComboBox<>();
        boxAktivitas.getItems().addAll("Jarang Sekali");
        boxAktivitas.getItems().addAll("Sedikit Aktif");
        boxAktivitas.getItems().addAll("Aktif");
        boxAktivitas.getItems().addAll("Sangat Aktif");
        boxAktivitas.setValue("Jarang Sekali"); 
    
        VBox Akg = new VBox(boxTujuan, boxGender, boxAktivitas, labelUsia, labelGender, labelBB, labelNama, labelTB, labelTujuan, labelAktivitas);
        Scene scene = new Scene(Akg, 750, 500);
        stage.setScene(scene);
        stage.show();

    }
}
