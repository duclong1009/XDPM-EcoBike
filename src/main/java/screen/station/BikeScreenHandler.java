package screen.station;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screen.FXMLScreenHandler;
import screen.bike.BikeDetailsScreen;
import utils.Configs;


import java.io.IOException;

/**
 * Man hinh Bike trong ViewStationDetailsHandler
 */
public class BikeScreenHandler extends FXMLScreenHandler {
    /**
     * @param screenPath
     * @throws IOException
     */

    @FXML
    private Button viewDetails;
    @FXML
    private Button copyBarcode;
    @FXML
    private Label bikeName;
    @FXML
    private ImageView bikeImage;
    public BikeScreenHandler(Stage stage, String screenPath) throws IOException {
        super(screenPath);

        viewDetails.setOnMouseClicked(e-> {
            try {
                BikeDetailsScreen bikeDetailsScreen = new BikeDetailsScreen(stage, Configs.BIKE_DETAILS_SCREEN_PATH);
                bikeDetailsScreen.requestViewBikeDetail();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

}
