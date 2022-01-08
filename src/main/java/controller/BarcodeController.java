package controller;

import subsystem.barcodesystem.BarcodeInterface;
import subsystem.barcodesystem.OriginBarcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Quan ly danh gia va gui barcode len server
 * @author dnkhanh
 */
public class BarcodeController extends BaseController{
    private BarcodeInterface barcodeConnector;

    public BarcodeController() {
        this.barcodeConnector = new OriginBarcode();
    }

    /**
     * Gui barcode len server
     * @param barcode
     * @return Bike id
     * @throws IOException
     * @throws URISyntaxException
     * @throws NumberFormatException
     */
    public int convertBarcodeToId(String barcode) throws IOException, URISyntaxException, NumberFormatException{
        String rawId = this.barcodeConnector.request(barcode);
        int id = Integer.parseInt(rawId);
        return id;
    }

    public String convertIdToBarcode(int id) {
        return String.valueOf(100 * id);
    }

    /**
     * Danh gia barcode
     * @param s
     * @return
     */
    public boolean validateBarcode(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        Pattern p = Pattern.compile("[A-Za-z0-9]");
        Matcher m = p.matcher(s);
        boolean b = m.find();
        return !b;
    }

}
