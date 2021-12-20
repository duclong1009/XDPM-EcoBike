package screen.RentBike;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import utils.Utils;

import java.io.IOException;
import java.util.logging.Logger;

public class BarcodeHandler extends BaseScreenHandler {
    public static Logger LOGGER = Utils.getLogger(BarcodeHandler.class.getName());
    @FXML
    private ImageView logo;
    public BarcodeHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);

        logo.setOnMouseClicked(e -> {
            LOGGER.info("User clicked Logo to return Home screen");
            homeScreenHandler.show();
        });

    }

    public void requestToBarCodeScreen(BaseScreenHandler prevScreen) {
        setPreviousScreen(prevScreen);
        setScreenTitle("BarCode");
        show(); }
    }

