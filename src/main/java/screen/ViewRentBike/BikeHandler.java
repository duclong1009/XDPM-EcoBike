package screen.ViewRentBike;

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
    public BikeHandler(String screenPath) throws IOException {
        super(screenPath);
    }

    private static Logger LOGGER = Utils.getLogger(BikeHandler.class.getName());
}
