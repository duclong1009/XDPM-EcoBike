package screen.barcode;

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
import screen.popup.PopupScreen;
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
            try {
                new HomeScreenHandler(stage,Configs.HOME_PATH).show();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        submit.setOnMouseClicked(e -> {
            try {
                String bc = barcode.getText();
                if(bc.equals("")) {
                    PopupScreen.error("Vui lòng nhập barcode");
                }
                else {
                    if(Rent.getBike() != null ) {
//                        System.out.println(bc);
//                        System.out.println(Rent.getBike().getId());
                        if(bc.equals(String.valueOf(Rent.getBike().getId()))) {
                            PopupScreen.success("Return bike Screen");
                        }
                        else {
                            PopupScreen.error("Nhap sai ma xe");
                        }
                    }
                    else {
                        LOGGER.info("Deposit Screen");
                        DepositScreenHandler depositScreenHandler = new DepositScreenHandler(stage, Configs.DEPOSIT_FORM_PATH, bc);
                        depositScreenHandler.requestToDeposit(this);
                    }

                }

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

    public void requestToBarCodeScreen() {
        setScreenTitle("BarCode");
        show(); }
    }


