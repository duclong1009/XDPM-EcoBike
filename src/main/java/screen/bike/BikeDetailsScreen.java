package screen.bike;

import controller.BaseController;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import screen.home.HomeScreenHandler;
import utils.Configs;

import java.io.IOException;
import java.sql.SQLException;

public class BikeDetailsScreen extends BaseScreenHandler {

//    private Stage homeStage;
    public BikeDetailsScreen(Stage stage, String screenPath) throws IOException {
        super(stage,screenPath);

    }

    public void requestViewBikeDetail() throws IOException, SQLException {
//        setPreviousScreen();
        setScreenTitle("View Bike Details");
        setHomeScreenHandler(new HomeScreenHandler(this.stage, Configs.HOME_PATH));
        show();
    }
}
