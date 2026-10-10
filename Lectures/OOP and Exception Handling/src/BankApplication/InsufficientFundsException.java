package BankApplication;

// Extending Exception directly makes this a checked exception.
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
