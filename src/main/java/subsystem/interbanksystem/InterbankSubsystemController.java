package subsystem.interbanksystem;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
//import checkout.exception.*;
import exception.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InterbankSubsystemController {
    private InterbankBoundary interbankBoundary = new InterbankBoundary();

    public PaymentTransaction payRental(CreditCard card, int amount, String contents) throws IOException, JSONException, ParseException {
        PaymentTransaction requestTransaction = new PaymentTransaction();
        requestTransaction.setCard(card);
        requestTransaction.setAmount(amount);
        requestTransaction.setTransactionContent(contents);
        requestTransaction.setCreateAt(new Date());

        String transactionRequest = getTransactionRequest(requestTransaction, "pay");
        System.out.println(getTransactionRequest(requestTransaction, "pay"));
        JSONObject response = interbankBoundary.request(transactionRequest);
        System.out.println(response);
        System.out.println(makePaymentTransaction(response));

        return makePaymentTransaction(response);
    }


    public PaymentTransaction refund(CreditCard card, int amount, String contents) throws IOException, JSONException, ParseException {
        PaymentTransaction requestTransaction = new PaymentTransaction();
        requestTransaction.setCard(card);
        requestTransaction.setAmount(amount);
        requestTransaction.setTransactionContent(contents);
        requestTransaction.setCreateAt(new Date());

        String transactionRequest = getTransactionRequest(requestTransaction, "refund");
        JSONObject response = interbankBoundary.request(transactionRequest);

        return makePaymentTransaction(response);
    }

    public static void main(String[] args) throws IOException, ParseException {
        InterbankSubsystemController interbankSubsystemController = new InterbankSubsystemController();
        interbankSubsystemController.payRental(new CreditCard(), 1000,"pay");
    }
    /**
     * Make payment transaction
     * and throw exception base on error code
     * @param response
     * @return
     * @throws PaymentException
     * @throws JSONException
     */
    private PaymentTransaction makePaymentTransaction(JSONObject response) throws PaymentException, JSONException, ParseException, IOException {
        if (response == null)
            return null;
        switch ((String) response.get("errorCode")) {
            case "00":
                break;
            case "01":
                throw new InvalidCardException();
            case "02":
                throw new NotEnoughBalanceException();
            case "03":
                throw new InternalServerErrorException();
            case "04":
                throw new SuspiciousTransactionException();
            case "05":
                throw new NotEnoughTransactionInfoException();
            case "06":
                throw new InvalidVersionException();
            case "07":
                throw new InvalidTransactionAmountException();
            default:
                throw new UnrecognizedException();
        }

        JSONObject transaction = response.getJSONObject("transaction");
        CreditCard card = new CreditCard((String) transaction.get("cardCode"), (String) transaction.get("owner"),
                (String) transaction.get("cvvCode"), (String) transaction.get("dateExpired"));
        PaymentTransaction trans = new PaymentTransaction((int) transaction.get("amount"), card,
                (String) transaction.get("transactionContent"), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse((String) transaction.get("createdAt")));

        return trans;
    }

    /**
     * Full transaction request for InterbankBoundary
     * @param paymentTransaction
     * @param command: "pay" or "refund"
     * @return
     * @throws JSONException
     */
    private String getTransactionRequest(PaymentTransaction paymentTransaction, String command) throws JSONException {
        JSONObject transaction = getJSONTransaction(paymentTransaction, command);

        String hashCode = getHashCode(getJsonToHashCode(transaction).toString());
        JSONObject bodyRequest = new JSONObject();

        bodyRequest.put("version", Config.API_VERSION);
        bodyRequest.put("transaction", transaction);
        bodyRequest.put("appCode", Config.APP_CODE);
        bodyRequest.put("hashCode", hashCode);
        return bodyRequest.toString();
    }

    /**
     * Hash code a string using md5 encoder
     * @param jsonString
     * @return
     */
    private String getHashCode(String jsonString){
        return DigestUtils.md5Hex(jsonString);
    }

    /**
     * Add secretKey and create an object to hash
     * @param jsonTransaction
     * @return
     * @throws JSONException
     */
    private JSONObject getJsonToHashCode(JSONObject jsonTransaction) throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("secretKey", Config.SECRET_KEY);
        obj.put("transaction", jsonTransaction);
//        System.out.println("OUt put getJsonToHashCode" + obj);
        return obj;
    }

    /**
     * Put transaction info to a JSONObject
     * @param paymentTransaction
     * @param command
     * @return
     * @throws JSONException
     */
    private JSONObject getJSONTransaction(PaymentTransaction paymentTransaction, String command) throws JSONException {
        JSONObject obj = new JSONObject();
        CreditCard creditCard = paymentTransaction.getCard();
        obj.put("command", command);
        obj.put("cardCode", creditCard.getCardCode());
        obj.put("owner", creditCard.getOwner());
        obj.put("cvvCode", creditCard.getCvvCode());
        obj.put("dateExpired", creditCard.getDateExpired());
        obj.put("transactionContent", paymentTransaction.getTransactionContent());
        obj.put("amount", paymentTransaction.getAmount());
        obj.put("createdAt", format(paymentTransaction.getCreateAt()));
//        System.out.println("OUtput getJsonTransaction " + obj);
        return obj;
    }

    private String format(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = formatter.format(date);
        System.out.println(strDate);
        return strDate;
    }
}
