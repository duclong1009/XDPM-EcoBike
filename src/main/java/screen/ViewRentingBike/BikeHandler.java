package screen.ViewRentingBike;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import screen.FXMLScreenHandler;
import utils.Utils;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Man hinh Bike nho trong man hinh RenBike
 */
public class BikeHandler extends FXMLScreenHandler {

    /**
     * @param screenPath
     * @throws IOException
     */
    @FXML
    private ImageView logo;
    public BikeHandler(String screenPath) throws IOException {
        super(screenPath);
    }

    private static Logger LOGGER = Utils.getLogger(BikeHandler.class.getName());
}
