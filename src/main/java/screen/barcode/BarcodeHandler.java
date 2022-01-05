package screen.barcode;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.deposit.DepositScreenHandler;
import screen.home.HomeScreenHandler;
import screen.station.ViewStationDetailsHandler;
import utils.Configs;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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
        setImage();
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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void setImage() {
        File file1 = new File(Configs.IMAGE_PATH + "/eco.png");
        System.out.println(file1.toURI().toString());
        Image img1 = new Image(file1.toURI().toString());
        logo.setImage(img1);
    }

    public void requestToBarCodeScreen(BaseScreenHandler prevScreen) {
        setPreviousScreen(prevScreen);
        setScreenTitle("BarCode");
        show(); }
    }


