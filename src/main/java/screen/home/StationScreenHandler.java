package screen.home;

import controller.BarcodeController;
import entity.rent.Rent;
import entity.station.Station;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import screen.FXMLScreenHandler;
import screen.barcode.BarcodeHandler;
import screen.popup.PopupScreen;
import screen.station.ViewStationDetailsHandler;
import utils.Configs;
import utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
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

    private Station station;
    public StationScreenHandler(Stage homeStage, String screenPath, Station station) throws IOException, SQLException {
        super(screenPath);
        this.station = station;
        viewsDetails.setOnMouseClicked(e -> {
            LOGGER.info("User clicked view station details");
            ViewStationDetailsHandler viewStationDetailsHandler;
            try {
                viewStationDetailsHandler = new ViewStationDetailsHandler(homeStage, Configs.STATION_DETAILS_SCREEN_PATH,station);
                viewStationDetailsHandler.requestToViewStationDetails();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        returnBikeHere.setOnMouseClicked(e -> {
            if (Rent.getBike() == null) {
                try {

                    PopupScreen.error("Ban chua thue xe");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else {
                try {
                    Rent.setStation_id(station.getId());
                    System.out.println(station.getId());
                    LOGGER.info(("User clicked to Rent Bike"));
                    BarcodeHandler barcodeHandler;
                    barcodeHandler = new BarcodeHandler(homeStage,Configs.BAR_CODE_SCREEN);
                    barcodeHandler.setBController(new BarcodeController());
                    barcodeHandler.requestToBarCodeScreen();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        setStationInfo();
    }

    public void setStationInfo() throws SQLException {
        nameStation.setText(this.station.getName());
        address.setText(this.station.getAddress());

    }
}