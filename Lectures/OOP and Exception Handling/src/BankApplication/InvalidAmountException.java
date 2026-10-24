package BankApplication;

public class InvalidAmountException extends IllegalArgumentException{
    InvalidAmountException(String message){
        super(message);
    }
}
