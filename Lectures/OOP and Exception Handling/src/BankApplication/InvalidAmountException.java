package BankApplication;

// IllegalArgumentException extends RuntimeException, so this is unchecked.
public class InvalidAmountException extends IllegalArgumentException {
    public InvalidAmountException(String message) {
        super(message);
    }
}
