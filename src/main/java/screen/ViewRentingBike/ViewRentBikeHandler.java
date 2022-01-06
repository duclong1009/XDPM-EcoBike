package screen.ViewRentingBike;

import entity.rent.Rent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screen.BaseScreenHandler;
import utils.Configs;
import utils.Utils;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ViewRentBikeHandler extends BaseScreenHandler {
    @FXML
    private ImageView logo;

    @FXML
    private Button copyBarcode;

    @FXML
    private  Button pause;

    @FXML
    private Text name;
    @FXML
    private Text station;
    @FXML
    private Text status;
    @FXML
    private Text depositFee;
    @FXML
    private Text time;
    @FXML
    private Text totalFee;


    public static Logger LOGGER = Utils.getLogger(ViewRentBikeHandler.class.getName());
    public ViewRentBikeHandler(Stage stage, String screenPath) throws IOException, SQLException {
        super(stage, screenPath);
        setImage();
        setInfo();
        logo.setOnMouseClicked(e -> {
            LOGGER.info("User clicked Logo to return Home screen");
            setScreenTitle("Home");
            homeScreenHandler.show();
        });

        copyBarcode.setOnMouseClicked(e-> {
            int id = Rent.getBike().getId();
            String barC = String.valueOf(id);
            try {
                Utils.copyToClipBoard(barC);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
//        addBikeHome();
    }

    public void setImage() {
        File file1 = new File(Configs.IMAGE_PATH + "/eco.png");
        Image img1 = new Image(file1.toURI().toString());
        logo.setImage(img1);
    }
    public void setInfo() throws SQLException {
        depositFee.setText(String.valueOf(Rent.getDepositFee()));
        name.setText(Rent.getBike().getBikeName());
        time.setText(String.valueOf(Rent.thoigiandathue()));


    }
    public void requestToViewRentBike(BaseScreenHandler prevScreen) {
        setPreviousScreen(prevScreen);
        setScreenTitle("View Rent Bike");
        show();}
}
