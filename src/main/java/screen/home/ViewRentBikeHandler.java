package screen.home;

import javafx.stage.Stage;
import screen.BaseScreenHandler;

import java.io.IOException;

public class ViewRentBikeHandler extends BaseScreenHandler {

    public ViewRentBikeHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);

    }

    public void requestToViewRentBike(BaseScreenHandler prevScreen) {
        setPreviousScreen(prevScreen);
        setScreenTitle("View Rent Bike");
        show();}

}
