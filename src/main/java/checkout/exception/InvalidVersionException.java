package checkout.exception;

public class InvalidVersionException extends PaymentException {
    public InvalidVersionException() {
        super("ERROR: Invalid version!");
    }
}
