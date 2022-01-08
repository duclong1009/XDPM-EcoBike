package subsystem.barcodesystem;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OriginBarcode implements BarcodeInterface{
    @Override
    public String request(String barcode) throws IOException, JSONException, URISyntaxException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("barcode", barcode);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:5000");
        URI uri = new URIBuilder(httpGet.getURI()).addParameter("barcode", barcode).build();
        httpGet.setURI(uri);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
        }
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity);
    }
}
