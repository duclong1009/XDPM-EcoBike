package screen.ViewRentBike;

import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.RentBike.BikeHandler;
import utils.Configs;
import utils.Utils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ViewRentBikeHandler extends BaseScreenHandler {
    @FXML
    private ImageView logo;
    @FXML
    private HBox hbox;
    @FXML
    private TextField search;

    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private SplitMenuButton searchMenu;

    public static Logger LOGGER = Utils.getLogger(ViewRentBikeHandler.class.getName());
    public ViewRentBikeHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        logo.setOnMouseClicked(e -> {
            LOGGER.info("User clicked Logo to return Home screen");
            homeScreenHandler.show();
        });
        ArrayList medium = new ArrayList<>();
        for(int i = 0; i <6;i++) {
            medium.add(new BikeHandler(Configs.BIKE_SCREEN));
        }

        addBikeHome(medium);
    }

    public void addBikeHome(List items) {
        ArrayList bikeList = (ArrayList)((ArrayList) items).clone();
        hbox.getChildren().forEach(node -> {
            VBox vBox = (VBox) node;
            vBox.getChildren().clear();
        });
        while (!bikeList.isEmpty()) {
            hbox.getChildren().forEach(node -> {
                int vid = hbox.getChildren().indexOf(node);
                VBox vBox = (VBox) node;
                while(vBox.getChildren().size()<3 && !bikeList.isEmpty()){
                    BikeHandler media = (BikeHandler) bikeList.get(0);
                    vBox.getChildren().add(media.getContent());
                    bikeList.remove(media);
                }
            });
        }
    }
    public void requestToViewRentBike(BaseScreenHandler prevScreen) {
        setPreviousScreen(prevScreen);
        setScreenTitle("View Rent Bike");
        show();}

}
