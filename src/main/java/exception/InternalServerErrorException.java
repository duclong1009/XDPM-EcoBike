package exception;

public class InternalServerErrorException extends PaymentException {
    public InternalServerErrorException() {
        super("ERROR: Internal server error!");
    }
}
