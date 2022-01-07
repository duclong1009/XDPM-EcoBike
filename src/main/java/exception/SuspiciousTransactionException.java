package exception;

public class SuspiciousTransactionException extends PaymentException {
    public SuspiciousTransactionException() {
        super("ERROR: Suspicious transaction!");
    }
}
