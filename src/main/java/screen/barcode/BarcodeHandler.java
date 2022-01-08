package screen.barcode;

import controller.BarcodeController;
import entity.rent.Rent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.deposit.DepositScreenHandler;
import screen.home.HomeScreenHandler;
import screen.payment.PaymentScreen;
import screen.popup.PopupScreen;
import screen.station.ViewStationDetailsHandler;
import utils.API;
import utils.Configs;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Man hinh barcode
 * @author dnkhanh
 */
public class BarcodeHandler extends BaseScreenHandler {
    public static Logger LOGGER = Utils.getLogger(BarcodeHandler.class.getName());
    @FXML
    private ImageView logo;

    @FXML
    private Button submit;
    @FXML
    private TextField barcode;

    public BarcodeHandler(Stage stage, String screenPath) throws IOException, URISyntaxException, NumberFormatException {
        super(stage, screenPath);
        setImage();
        logo.setOnMouseClicked(e -> {
            LOGGER.info("User clicked Logo to return Home screen");
            setScreenTitle("Home");
            try {
                new HomeScreenHandler(stage,Configs.HOME_PATH).show();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        BarcodeController barcodeController = new BarcodeController();
        submit.setOnMouseClicked(e -> {
            try {
                String bc =  barcode.getText();
                int id = barcodeController.convertBarcodeToId(bc);

                if(!barcodeController.validateBarcode(bc)) {
                    PopupScreen.error("Barcode is invalid");
                }
                else {
                    if(Rent.getBike() != null ) {
                        if(id == Rent.getBike().getId()) {
                            PaymentScreen paymentScreen = new PaymentScreen(stage, Configs.PAYMENT_SCREEN_PATH);
                            paymentScreen.requestPayment();
                        }
                        else {
                            PopupScreen.error("Nhap sai ma xe");
                        }
                    }
                    else {
                        try {
                            LOGGER.info("Deposit Screen");
                            DepositScreenHandler depositScreenHandler = new DepositScreenHandler(stage, Configs.DEPOSIT_FORM_PATH, id);
                            depositScreenHandler.requestToDeposit(this);
                        }
                        catch (Exception ex) {

                            PopupScreen.error("Barcode không đúng");
                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void setImage() {
        File file1 = new File(Configs.IMAGE_PATH + "/eco.png");
        Image img1 = new Image(file1.toURI().toString());
        logo.setImage(img1);
    }

    public void requestToBarCodeScreen() {
        setScreenTitle("BarCode");
        show(); }
    }


