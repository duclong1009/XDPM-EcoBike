package screen.station;

import controller.BarcodeController;
import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screen.FXMLScreenHandler;
import screen.bike.BikeDetailsScreen;
import utils.API;
import utils.Configs;
import utils.Utils;


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

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

    private Bike bike;
    public static Logger LOGGER = Utils.getLogger(BikeScreenHandler.class.getName());
    public BikeScreenHandler(Stage stage, String screenPath, Bike bike) throws IOException, SQLException {
        super(screenPath);
        this.bike = bike;

        viewDetails.setOnMouseClicked(e-> {
            try {
                LOGGER.info("User clicked view bike details");
                BikeDetailsScreen bikeDetailsScreen = new BikeDetailsScreen(stage, Configs.BIKE_DETAILS_SCREEN_PATH,bike);
                bikeDetailsScreen.requestViewBikeDetail();
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
            }
        });
        copyBarcode.setOnMouseClicked(e -> {
            try {
                LOGGER.info("User clicked copy barcode");
                BarcodeController barcodeController = new BarcodeController();
                String barC = barcodeController.convertIdToBarcode(bike.getId());
                Utils.copyToClipBoard(barC);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        setBikeInfo();
    }

    public void setBikeInfo() throws  SQLException {
        bikeName.setText(this.bike.getBikeName());
        File file1 = new File(Configs.IMAGE_PATH + "/" +bike.getImagePath());
        javafx.scene.image.Image img1 = new Image(file1.toURI().toString());
        bikeImage.setImage(img1);

    }

}
