package screen.station;

import controller.HomeController;
import entity.bike.Bike;
import entity.station.Station;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.home.HomeScreenHandler;
import utils.Configs;
import utils.Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Lop handler Station-Details-Screen man hinh sau khi bam vao view details tu man hinh home.
 */
public class ViewStationDetailsHandler extends BaseScreenHandler {

    public static Logger LOGGER = Utils.getLogger(ViewStationDetailsHandler.class.getName());

    @FXML
    private HBox hBox;

    @FXML
    private ImageView logo;

    @FXML
    private Text stationName;

    @FXML
    private Text locationName;

//    @FXML
//    private Te

    private  HomeScreenHandler home;
    private Station station;

    public ViewStationDetailsHandler(Stage stage, String screenPath, Station station) throws IOException, SQLException {

        super(stage, screenPath);
        LOGGER.info("Opening ViewStationDetail");
        this.station = station;
        System.out.println("Station ID" +station.getId());
        this.home = new HomeScreenHandler(stage,Configs.HOME_PATH);
        logo.setOnMouseClicked(e -> {
            LOGGER.info("User clicked Logo to return Home screen");
            setScreenTitle("Home");
            home.show();
        });
        this.setBController(new HomeController());
        HomeController controller = (HomeController) getBController();
        List bikeList = controller.getAllBike(station.getId());
        System.out.println(bikeList.size());
        List bikeHandler = new ArrayList<>();
        for(Object object : bikeList) {
            Bike bike = (Bike) object;
            bikeHandler.add(new BikeScreenHandler(stage,Configs.BIKE_STATION_PATH,bike));
        }
//        for(int i = 0; i <6;i++) {
//            medium.add(new BikeScreenHandler(stage,Configs.BIKE_STATION_PATH));
//        }
        addBikeStation(bikeHandler);
        setStationInfo();
    }

    public void addBikeStation(List items) {
        ArrayList bikeList = (ArrayList)((ArrayList) items).clone();
        hBox.getChildren().forEach(node -> {
            VBox vBox = (VBox) node;
            vBox.getChildren().clear();
        });
        while (!bikeList.isEmpty()) {
            hBox.getChildren().forEach(node -> {
                int vid = hBox.getChildren().indexOf(node);
                VBox vBox = (VBox) node;
                while(vBox.getChildren().size()<3 && !bikeList.isEmpty()){
                    BikeScreenHandler media = (BikeScreenHandler) bikeList.get(0);
                    vBox.getChildren().add(media.getContent());
                    bikeList.remove(media);
                }
            });
        }

    }
    public void setStationInfo() {
        LOGGER.info("Station name " + this.station.getName());
        stationName.setText(this.station.getName());
        locationName.setText(this.station.getAddress());
    }

    public void requestToViewStationDetails() {
    setScreenTitle("View Station Details");
    setHomeScreenHandler(this.home);
    show();
    }
}
