package screen.ViewRentingBike;

import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
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
    private SplitMenuButton searchMenu;

    public static Logger LOGGER = Utils.getLogger(ViewRentBikeHandler.class.getName());
    public ViewRentBikeHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        logo.setOnMouseClicked(e -> {
            LOGGER.info("User clicked Logo to return Home screen");
            setScreenTitle("Home");
            homeScreenHandler.show();
        });
        addBikeHome();
    }

    public void addBikeHome() throws IOException {
        BikeHandler bikeHandler = new BikeHandler(Configs.BIKE_SCREEN);
        hbox.getChildren().add(bikeHandler.getContent());
    }

    public void requestToViewRentBike(BaseScreenHandler prevScreen) {
        setPreviousScreen(prevScreen);
        setScreenTitle("View Rent Bike");
        show();}
}
