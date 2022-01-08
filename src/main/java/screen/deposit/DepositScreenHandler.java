package screen.deposit;

import controller.DepositController;
import controller.PaymentController;
import entity.bike.Bike;
import entity.payment.CreditCard;
import entity.rent.Rent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.home.HomeScreenHandler;
import screen.popup.PopupScreen;
import utils.Configs;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DepositScreenHandler extends BaseScreenHandler {

    @FXML
    private ImageView logo;
    @FXML
    private Text bikeName;
    @FXML
    private  Text depositFee;
    @FXML
    private ImageView bikeImage;
    @FXML
    private TextField cardholderName;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField issuingBank;
    @FXML
    private TextField expirationDate;
    @FXML
    private PasswordField securityCode;
    @FXML
    private Button submit;

    private HomeScreenHandler home;
    private Logger LOGGER = Utils.getLogger(DepositScreenHandler.class.getName());

    public DepositScreenHandler(Stage stage, String screenPath,int bikeID) throws IOException, SQLException {
        super(stage, screenPath);
        setImage();
//        setInfo(bike);
        Bike bike = new Bike().getBikeById(bikeID);
        setInfo(bike);
        logo.setOnMouseClicked(e-> {
            try {
                LOGGER.info("User clicked to return Home Screen");
                this.home = new HomeScreenHandler(stage, Configs.HOME_PATH);
                setScreenTitle("Home");
                home.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
        DepositController depositController = new DepositController();
        int depositFees = depositController.calDepositFee(bike.getCategory());
        depositFee.setText(String.valueOf(depositFees) + " VND");
        submit.setOnMouseClicked(e-> {
            PaymentController paymentController = new PaymentController();
            try {
                if (!depositController.validateName(cardholderName.getText()) || !depositController.validateCardNumber(cardNumber.getText()) || !depositController.validateExpirationDate(expirationDate.getText()) || !depositController.validateSecurityCode(securityCode.getText())) {
                    PopupScreen.error("Card info is invalid!");
                }
                else if (paymentController.payRental(depositFees,"DAT COC 400k",securityCode.getText(),cardholderName.getText(),cardNumber.getText(),expirationDate.getText())) {
                    PopupScreen.success("Deposit Successfully");
                    Rent.setDepositFee(depositFees);
                    Rent.setBike(bike);
                    Rent.setStartTime();
                    Rent.setCard(new CreditCard(securityCode.getText(),cardholderName.getText(),cardNumber.getText(),expirationDate.getText()));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//
                });
    }

    public void setImage() {
        File file1 = new File(Configs.IMAGE_PATH + "/eco.png");
        Image img1 = new Image(file1.toURI().toString());
        logo.setImage(img1);
    }
    public void setInfo(Bike bike) {
        bikeName.setText(bike.getBikeName());
        File file1 = new File(Configs.IMAGE_PATH + "/" + bike.getImagePath());
        Image img1 = new Image(file1.toURI().toString());
        bikeImage.setImage(img1);
//        bikeImage.setImage(Configs.IMAGE_PATH + "/" + bike.getImagePath());

    }
    public void requestToDeposit(BaseScreenHandler prev) {
        setScreenTitle("Deposit Form");
        setPreviousScreen(prev);
        show();
    }

}
