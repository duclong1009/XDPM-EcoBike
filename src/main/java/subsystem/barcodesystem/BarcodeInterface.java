package subsystem.barcodesystem;

import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface BarcodeInterface {
    String request(String barcode) throws IOException, JSONException, URISyntaxException;
}
