package controller;

import subsystem.barcodesystem.BarcodeInterface;
import subsystem.barcodesystem.OriginBarcode;

import java.io.IOException;
import java.net.URISyntaxException;

public class BarcodeController extends BaseController{
    private BarcodeInterface barcodeConnector;

    public BarcodeController() {
        this.barcodeConnector = new OriginBarcode();
    }

    public int getIdByBarcode(String barcode) throws IOException, URISyntaxException, NumberFormatException{
        String rawId = this.barcodeConnector.request(barcode);
        int id = Integer.parseInt(rawId);
        return id;
    }
}
