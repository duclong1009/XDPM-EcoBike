package exception;

public class NotEnoughBalanceException extends PaymentException {
    public NotEnoughBalanceException() {
        super("ERROR: Not enough balance!");
    }
}
