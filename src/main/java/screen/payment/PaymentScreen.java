package screen.payment;

import controller.PaymentController;
import controller.RentBikeController;
import entity.bike.Bike;
import entity.rent.Rent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.home.HomeScreenHandler;
import screen.popup.PopupScreen;
import utils.Configs;
import utils.Utils;
import utils.calculatefee.CalFee1;

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

    public  PaymentScreen (Stage stage, String path) throws IOException, SQLException {
        super(stage,path);
        setImage();
        setInfo();
        logo.setOnMouseClicked(e -> {
            LOGGER.info("User clicked Logo to return Home screen");
            setScreenTitle("Home");
            homeScreenHandler.show();
        });

        returnButton.setOnMouseClicked(e-> {
            int rF = new RentBikeController(new CalFee1()).calRentalFee(Rent.getBike().getCategory());
            LOGGER.info("User clicked to return");
            try {
                PaymentController paymentController = new PaymentController();
                if(paymentController.refund(Rent.getDepositFee() - rF,"Refund",Rent.getCard())) {
                    PopupScreen.success("Payment Successfully");
                    Bike bike = Rent.getBike();
                    System.out.println("Station" + Rent.getStation_id());
                    bike.setStation(Rent.getStation_id());
                    bike.updateStationIdById(bike.getId(),Rent.getStation_id());

                    // save bike;
                    Rent.reset();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            // ******* Code return bike and save to transaction db **********
            try {
                PopupScreen.success("Return Bike Successfully");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });



    }
    public void setImage() {
        File file1 = new File(Configs.IMAGE_PATH + "/eco.png");
        Image img1 = new Image(file1.toURI().toString());
        logo.setImage(img1);
    }
    public void setInfo() throws SQLException {
        int rF = new RentBikeController(new CalFee1()).calRentalFee(Rent.getBike().getCategory());
        rentalFee.setText(rF+ " VND");
        bikeName.setText(Rent.getBike().getBikeName());
        depositFee.setText(Rent.getDepositFee() + "VND");
        time.setText(Rent.thoigiandathue() + " phút");
        refund.setText(Rent.getDepositFee() - rF + " VND");
        File file2 = new File(Configs.IMAGE_PATH + "/" +Rent.getBike().getImagePath());
        javafx.scene.image.Image img2 = new Image(file2.toURI().toString());
        bikeImage.setImage(img2);
    }
    public void requestPayment() throws IOException, SQLException {
//        setPreviousScreen();
        setScreenTitle("Payment");
        setHomeScreenHandler(new HomeScreenHandler(this.stage, Configs.HOME_PATH));
        // *** code set text rent fee, refund //
        show();
    }
}
