package screen.deposit;

import entity.bike.Bike;
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
    public DepositScreenHandler(Stage stage, String screenPath) throws IOException, SQLException {
        super(stage, screenPath);
        setImage();
//        setInfo(bike);
        logo.setOnMouseClicked(e-> {
            try {
                this.home = new HomeScreenHandler(stage, Configs.HOME_PATH);
                setScreenTitle("Home");
                home.show();
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
    public void setInfo(Bike bike) {
        bikeName.setText(bike.getBikeName());

    }
    public void requestToDeposit(BaseScreenHandler prev) {
        setScreenTitle("Deposit Form");
        setPreviousScreen(prev);
//        setImage();
        show();
    }

}
