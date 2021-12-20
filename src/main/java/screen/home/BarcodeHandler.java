package screen.home;

import javafx.stage.Stage;
import screen.BaseScreenHandler;

import java.io.IOException;

public class BarcodeHandler extends BaseScreenHandler {
    public BarcodeHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public void requestToBarCodeScreen(BaseScreenHandler prevScreen) {
        setPreviousScreen(prevScreen);
        setScreenTitle("BarCode");
        show();}
    }

