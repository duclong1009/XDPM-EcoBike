package screen.bike;

import controller.BaseController;
import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.home.HomeScreenHandler;
import screen.station.BikeScreenHandler;
import utils.Configs;
import utils.Utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class BikeDetailsScreen extends BaseScreenHandler {

//    private Stage homeStage;
    @FXML
    private ImageView logo;
//    @FXML
//    private ImageView bikeImage;
    @FXML
    private Text bikeName;
    @FXML
    private  Text description;
    @FXML
    private  Text depositFee;
    @FXML
    private Text usableTime;
    @FXML
    private Button copyBarcode;
    public static Logger LOGGER = Utils.getLogger(BikeDetailsScreen.class.getName());
    private HomeScreenHandler home;
    public BikeDetailsScreen(Stage stage, String screenPath, Bike bike) throws IOException, SQLException {
        super(stage,screenPath);
        setInfo(bike);
        logo.setOnMouseClicked(e -> {
            try {
                this.home = new HomeScreenHandler(stage,Configs.HOME_PATH);
                LOGGER.info("User clicked Logo to return Home screen");
                setScreenTitle("Home");
                home.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
        copyBarcode.setOnMouseClicked(e -> {
            try {
                int barC = bike.getId();
                Utils.copyToClipBoard(String.valueOf(barC));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void setInfo(Bike b) {
        bikeName.setText((b.getBikeName()));
//        File file2 = new File(Configs.IMAGE_PATH + "/" + b.getStatus())
//        bikeImage.setImage();
        description.setText(String.valueOf(b.getStatus()));
        setImage();
    }

    public void requestViewBikeDetail() throws IOException, SQLException {
//        setPreviousScreen();
        setScreenTitle("View Bike Details");
        setHomeScreenHandler(new HomeScreenHandler(this.stage, Configs.HOME_PATH));
        show();
    }
    public void setImage() {
        File file1 = new File(Configs.IMAGE_PATH + "/eco.png");
        javafx.scene.image.Image img1 = new Image(file1.toURI().toString());
        logo.setImage(img1);


    }
}
