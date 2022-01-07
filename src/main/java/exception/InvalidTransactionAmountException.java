package exception;

public class InvalidTransactionAmountException extends PaymentException {

    public InvalidTransactionAmountException() {
        super("ERROR: Invalid transaction amount!");
    }
}
