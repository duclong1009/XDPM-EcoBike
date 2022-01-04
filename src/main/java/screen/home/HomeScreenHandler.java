package screen.home;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import controller.BarcodeController;
import controller.HomeController;
//import controller.ViewCartController;
//import entity.cart.Cart;
//import entity.media.Media;
import controller.ViewRentBikeController;
import entity.station.Station;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.barcode.BarcodeHandler;
import screen.ViewRentingBike.ViewRentBikeHandler;
import utils.Configs;
import utils.Utils;
//import views.screen.BaseScreenHandler;
//import views.screen.cart.CartScreenHandler;

/**
 * Man hinh home xu ly Home-Screen
 */
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
    @FXML
    private HBox hBox;
    @FXML
    private VBox vBox1;
    @FXML
    private VBox vBox2;
    public HomeScreenHandler(Stage stage, String screenPath) throws IOException, SQLException {
        super(stage, screenPath);
        LOGGER.info("Open Home Screen");
        this.setBController(new HomeController());
        List stationList = getBController().getAllStation();
        List stationHandler = new ArrayList<>();
        for(Object object : stationList) {
            Station st = (Station) object;
            stationHandler.add(new StationScreenHandler(stage,Configs.STATION_SCREEN_PATH, st));
        }
//        for(int i = 0; i <6;i++) {
//            medium.add(new StationScreenHandler(stage,Configs.STATION_SCREEN_PATH));
//        }
        addStationHome(stationHandler);
    }

    public void addStationHome(List items) {
        ArrayList stationList = (ArrayList)((ArrayList) items).clone();
        hBox.getChildren().forEach(node -> {
            VBox vBox = (VBox) node;
            vBox.getChildren().clear();
        });
        while (!stationList.isEmpty()) {
            hBox.getChildren().forEach(node -> {
                int vid = hBox.getChildren().indexOf(node);
                VBox vBox = (VBox) node;
                while(vBox.getChildren().size()<3 && !stationList.isEmpty()){
                    StationScreenHandler media = (StationScreenHandler) stationList.get(0);
                    vBox.getChildren().add(media.getContent());
                    stationList.remove(media);
                }
            });
        }
    }


    public HomeController getBController() {
        return (HomeController) super.getBController();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        setBController(new HomeController());
        try {

            System.out.println("init home screen");
//            }
        } catch (Exception e) {
            LOGGER.info("Errors occured: " + e.getMessage());
            e.printStackTrace();
        }
        viewRentBike.setOnMouseClicked(e -> {
            ViewRentBikeHandler viewRentBikeHandler;
            try{
                LOGGER.info("User clicked to view renting bike");
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
                barcodeHandler.setPreviousScreen(this);
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

