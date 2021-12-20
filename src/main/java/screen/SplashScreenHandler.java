package screen;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *  Khởi tạo màn hình splash
 */
public class SplashScreenHandler implements Initializable {

    @FXML
    ImageView logo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("assets/image/eco_bike_logo.jpg");
        Image image = new Image(file.toURI().toString());
        logo.setImage(image);
    }
}