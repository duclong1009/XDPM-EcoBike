package subsystem.interbanksystem;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;

public class TestAPI {
    public static void main(String[] args) throws IOException, JSONException, ParseException {
        InterbankInterface interbank = new InterbankSubsystem();
            CreditCard creditCard = new CreditCard("kstn_group5_2021", "Group 5", "648", "1125");

        PaymentTransaction paymentTransaction = interbank.refund(creditCard, 10000000, "hoan tien 100k");
        System.out.println(paymentTransaction);
        System.out.println("Refund OK");

//        PaymentTransaction paymentTransaction1 = interbankpayRental(creditCard, 500000, "thanh toan 500k");
//        System.out.println(paymentTransaction1);
        System.out.println("Pay OK");
    }
}
