package screen.home;

import controller.ViewRentBikeController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.FXMLScreenHandler;
import screen.ViewRentBike.ViewRentBikeHandler;
import screen.station.ViewStationDetailsHandler;
import utils.Configs;
import utils.Utils;
import java.io.IOException;
import java.util.logging.Logger;

public class StationScreenHandler extends FXMLScreenHandler {
    public static Logger LOGGER = Utils.getLogger(StationScreenHandler.class.getName());

    @FXML
    private Label nameStation;

    @FXML
    private Label address;

    @FXML
    private Button viewsDetails;

    @FXML
    private Button returnBikeHere;
//    @FXML
//    private Stage homeStage;/
    public StationScreenHandler(Stage homeStage,String screenPath) throws IOException {
        super(screenPath);
//        this.homeStage = homeStage;
        viewsDetails.setOnMouseClicked(e -> {
            LOGGER.info("User clicked view station details");
            ViewStationDetailsHandler viewStationDetailsHandler;
            try {
                viewStationDetailsHandler = new ViewStationDetailsHandler(homeStage, Configs.STATION_DETAILS_SCREEN_PATH);
//                viewStationDetailsHandler.setHomeScreenHandler(this.homeHandle);
                viewStationDetailsHandler.requestToViewStationDetails();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}