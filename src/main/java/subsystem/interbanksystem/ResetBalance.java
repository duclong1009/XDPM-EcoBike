package subsystem.interbanksystem;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;

public class ResetBalance {
    private static CreditCard card = new CreditCard("kstn_group5_2021", "Group 5", "648", "1125");

    public static JSONObject resetRequest(CreditCard card) throws IOException, JSONException {
        JSONObject cardInfo = new JSONObject();
        cardInfo.put("cardCode", card.getCardCode());
        cardInfo.put("owner", card.getOwner());
        cardInfo.put("cvvCode", card.getCvvCode());
        cardInfo.put("dateExpired", card.getDateExpired());

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch(Config.BASE_URL + "/api/card/reset-balance");
        httpPatch.setEntity(new StringEntity(cardInfo.toString(), ContentType.APPLICATION_JSON));
        HttpResponse httpResponse = httpClient.execute(httpPatch);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
        }
        HttpEntity httpEntity = httpResponse.getEntity();

        return new JSONObject(EntityUtils.toString(httpEntity));
    }

    public static void main (String[] args) throws IOException, JSONException, ParseException {
//        JSONObject response = resetRequest(card);
//        System.out.println(response.get("balance"));
        InterbankSubsystem interbank = new InterbankSubsystem();
        PaymentTransaction ref = interbank.refund(card, 1000000000, "refund");
    }
}
