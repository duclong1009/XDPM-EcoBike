package screen.home;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import controller.BarcodeController;
import controller.HomeController;
//import controller.ViewCartController;
//import entity.cart.Cart;
//import entity.media.Media;
import controller.ViewRentBikeController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.RentBike.BarcodeHandler;
import screen.ViewRentBike.ViewRentBikeHandler;
import utils.Configs;
import utils.Utils;
//import views.screen.BaseScreenHandler;
//import views.screen.cart.CartScreenHandler;


public class HomeScreenHandler extends BaseScreenHandler implements Initializable {

    public static Logger LOGGER = Utils.getLogger(HomeScreenHandler.class.getName());

    @FXML
    private ImageView logo;

    @FXML
    private TextField searchField;

    @FXML
    private SplitMenuButton searchMenu;

    @FXML
    private Button rentBike;

    @FXML
    private Button viewRentBike;

    @FXML
    private Button returnBikeHere6;

    public HomeScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public HomeController getBController() {
        return (HomeController) super.getBController();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        setBController(new HomeController());
        try {
//            List medium = getBController().getAllMedia();
//            this.homeItems = new ArrayList<>();
//            for (Object object : medium) {
//                Media media = (Media)object;
//                MediaHandler m1 = new MediaHandler(Configs.HOME_MEDIA_PATH, media, this);
//                this.homeItems.add(m1);
            System.out.println("init home screen");
//            }
        } catch (Exception e) {
            LOGGER.info("Errors occured: " + e.getMessage());
            e.printStackTrace();
        }
        viewRentBike.setOnMouseClicked(e -> {
            ViewRentBikeHandler viewRentBikeHandler;
            try{
                LOGGER.info("User clicked to view rent bike");
                viewRentBikeHandler = new ViewRentBikeHandler(this.stage,Configs.RENTAL_BIKE_SCREEN_PATH);
                viewRentBikeHandler.setBController(new ViewRentBikeController());
                viewRentBikeHandler.setHomeScreenHandler(this);
                viewRentBikeHandler.requestToViewRentBike(this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        rentBike.setOnMouseClicked(e-> {
            BarcodeHandler barcodeHandler;
            try {
                LOGGER.info(("User clicked to Rent Bike"));
                barcodeHandler = new BarcodeHandler(this.stage,Configs.BAR_CODE_SCREEN);
                barcodeHandler.setBController(new BarcodeController());
                barcodeHandler.setHomeScreenHandler(this);
                barcodeHandler.requestToBarCodeScreen(this);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

        });

    }

    public void setImage() {
//        fix image path caused by fxml
        File file1 = new File("/assets/image/eco_bike_logo.jpg");
//        System.out.println(file1.toURI().toString());
        Image img1 = new Image(file1.toURI().toString());
        logo.setImage(img1);
    }

}

