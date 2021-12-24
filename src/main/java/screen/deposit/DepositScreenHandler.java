package screen.deposit;

import javafx.stage.Stage;
import screen.BaseScreenHandler;

import java.io.IOException;

public class DepositScreenHandler extends BaseScreenHandler {
    public DepositScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public void requestToDeposit(BaseScreenHandler prev) {
        setScreenTitle("Deposit Form");
        setPreviousScreen(prev);
        show();
    }

}
