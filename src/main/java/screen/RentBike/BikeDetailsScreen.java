package screen.RentBike;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.ViewRentingBike.ViewRentBikeHandler;
import screen.home.HomeScreenHandler;
import utils.Configs;
import utils.Utils;

import java.io.IOException;
import java.util.logging.Logger;

public class BikeDetailsScreen extends BaseScreenHandler {
    public static Logger LOGGER = Utils.getLogger(BikeDetailsScreen.class.getName());
    @FXML
    private ImageView logo;


    public BikeDetailsScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }
}
