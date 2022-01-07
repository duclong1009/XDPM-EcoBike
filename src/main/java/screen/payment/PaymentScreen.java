package screen.payment;

import entity.rent.Rent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.ViewRentingBike.ViewRentBikeHandler;
import screen.home.HomeScreenHandler;
import utils.Configs;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PaymentScreen extends BaseScreenHandler {

    @FXML
    private ImageView logo;
    @FXML
    private ImageView bikeImage;
    @FXML
    private Text bikeName;
    @FXML
    private  Text depositFee;
    @FXML
    private  Text time;
    @FXML
    private  Text rentalFee;
    @FXML
    private Text refund;
    @FXML
    private Button returnButton;

    public static Logger LOGGER = Utils.getLogger(PaymentScreen.class.getName());

    public  PaymentScreen (Stage stage, String path) throws IOException {
        super(stage,path);
        setImage();
        setInfo();
        logo.setOnMouseClicked(e -> {
            LOGGER.info("User clicked Logo to return Home screen");
            setScreenTitle("Home");
            homeScreenHandler.show();
        });

        returnButton.setOnMouseClicked(e-> {
            LOGGER.info("User clicked to return");

            // ******* Code return bike and save to transaction db **********
        });



    }
    public void setImage() {
        File file1 = new File(Configs.IMAGE_PATH + "/eco.png");
        Image img1 = new Image(file1.toURI().toString());
        logo.setImage(img1);
    }
    public void setInfo() {
        bikeName.setText(Rent.getBike().getBikeName());
    }
    public void requestPayment() throws IOException, SQLException {
//        setPreviousScreen();
        setScreenTitle("Payment");
        setHomeScreenHandler(new HomeScreenHandler(this.stage, Configs.HOME_PATH));
        depositFee.setText(String.valueOf(Rent.getDepositFee()));
        time.setText(String.valueOf(Rent.thoigiandathue()));
        // *** code set text rent fee, refund //
        show();
    }
}
