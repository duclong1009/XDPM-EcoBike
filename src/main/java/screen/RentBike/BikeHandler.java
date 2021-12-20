package screen.RentBike;

import screen.FXMLScreenHandler;
import utils.Utils;

import java.io.IOException;
import java.util.logging.Logger;

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
