package screen.barcode;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.deposit.DepositScreenHandler;
import screen.home.HomeScreenHandler;
import screen.station.ViewStationDetailsHandler;
import utils.Configs;
import utils.Utils;

import java.io.IOException;
import java.util.logging.Logger;

public class BarcodeHandler extends BaseScreenHandler {
    public static Logger LOGGER = Utils.getLogger(BarcodeHandler.class.getName());
    @FXML
    private ImageView logo;

    @FXML
    private Button submit;
    @FXML
    private TextField barcode;

    public BarcodeHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);

        logo.setOnMouseClicked(e -> {
            LOGGER.info("User clicked Logo to return Home screen");
            setScreenTitle("Home");
            homeScreenHandler.show();
        });
        submit.setOnMouseClicked(e -> {
            try {
                LOGGER.info("Deposit Screen , prev Screen HomeScreen");
                DepositScreenHandler depositScreenHandler = new DepositScreenHandler(stage, Configs.DEPOSIT_FORM_PATH);
                depositScreenHandler.requestToDeposit(this);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void requestToBarCodeScreen(BaseScreenHandler prevScreen) {
        setPreviousScreen(prevScreen);
        setScreenTitle("BarCode");
        show(); }
    }


