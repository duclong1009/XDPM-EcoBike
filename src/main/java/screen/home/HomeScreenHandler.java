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
//import controller.ViewCartController;
//import entity.cart.Cart;
//import entity.media.Media;
import controller.StationController;
import entity.rent.Rent;
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
import screen.popup.PopupScreen;
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
    private Button searchMenu;

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
        StationController stationController =  new StationController();
        setImage();
        LOGGER.info("Open Home Screen");
        List stationList = stationController.getAllStation();
        List stationHandler = new ArrayList<>();
        hBox.getChildren().forEach(node -> {
            VBox vBox = (VBox) node;
            vBox.getChildren().clear();
        });
        for(Object object : stationList) {
            Station st = (Station) object;
            stationHandler.add(new StationScreenHandler(stage,Configs.STATION_SCREEN_PATH, st));
        }
        addStationHome(stationHandler);
        searchMenu.setOnMouseClicked(e -> {

            try {
                String searchStr = searchField.getText();
                List stationListSearch = stationController.getSearchStation(searchStr);
                List stationHandlerSearch = new ArrayList<>();
                if(stationListSearch.size() == 0) {
                    PopupScreen.error("Không có bãi xe phù hợp");
                }
                else {
                    for(Object object : stationListSearch) {
                        Station st = (Station) object;
                        stationHandlerSearch.add(new StationScreenHandler(stage,Configs.STATION_SCREEN_PATH, st));
                    }
                    addStationHome(stationHandlerSearch);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        viewRentBike.setOnMouseClicked(e -> {
            if(Rent.getBike() == null) {
                try {
                    PopupScreen.error("Chua thue xe");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else {
                ViewRentBikeHandler viewRentBikeHandler;

                try{
                    LOGGER.info("User clicked to view renting bike");
                    viewRentBikeHandler = new ViewRentBikeHandler(this.stage,Configs.RENTAL_BIKE_SCREEN_PATH);
//                viewRentBikeHandler.setBController(new ViewRentBikeController());
                    viewRentBikeHandler.setHomeScreenHandler(this);
                    viewRentBikeHandler.requestToViewRentBike(this);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        rentBike.setOnMouseClicked(e-> {

            try {
                LOGGER.info(("User clicked to Rent Bike"));
                BarcodeHandler barcodeHandler;
                barcodeHandler = new BarcodeHandler(this.stage,Configs.BAR_CODE_SCREEN);
                barcodeHandler.setBController(new BarcodeController());
                barcodeHandler.setHomeScreenHandler(this);
                barcodeHandler.setPreviousScreen(this);
                barcodeHandler.requestToBarCodeScreen();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }

    public void setImage() {
        File file1 = new File(Configs.IMAGE_PATH + "/eco.png");
        Image img1 = new Image(file1.toURI().toString());
        logo.setImage(img1);
    }

}

