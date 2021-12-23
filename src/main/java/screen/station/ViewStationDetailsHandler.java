package screen.station;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.home.StationScreenHandler;
import utils.Configs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewStationDetailsHandler extends BaseScreenHandler {
    @FXML
    private HBox hBox;


    public ViewStationDetailsHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        ArrayList medium = new ArrayList<>();
        for(int i = 0; i <6;i++) {
            medium.add(new BikeScreenHandler(Configs.BIKE_STATION_PATH));
        }
        addBikeStation(medium);
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


    public void requestToViewStationDetails() {
//    setPreviousScreen();
    setScreenTitle("View Station Details");
    show();
}
}
