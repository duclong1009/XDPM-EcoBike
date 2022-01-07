package subsystem.interbanksystem;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import exception.PaymentException;
import exception.UnrecognizedException;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;

public class InterbankSubsystem implements InterbankInterface{

    /**
     * Represent the controller of the subsystem
     */
    private InterbankSubsystemController ctrl;

    /**
     * Initialize a newly created InterbankSubsystem object
     * so that it represents an Interbank subsystem
     */
    public InterbankSubsystem() {
        this.ctrl = new InterbankSubsystemController();
    }

    /**
     * @see InterbankInterface#payRental(CreditCard, int, String)
     */
    public PaymentTransaction payRental(CreditCard card, int amount, String contents) throws PaymentException, UnrecognizedException, IOException, JSONException, ParseException {
        PaymentTransaction transaction = ctrl.payRental(card, amount, contents);
        return transaction;
    }

    /**
     * @see InterbankInterface#refund(CreditCard, int, String)
     */
    public PaymentTransaction refund(CreditCard card, int amount, String contents) throws PaymentException, UnrecognizedException, IOException, JSONException, ParseException {
        PaymentTransaction transaction = ctrl.refund(card, amount, contents);
        return transaction;
    }
}
