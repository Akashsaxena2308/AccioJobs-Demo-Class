package BankApplication;

public class Invalid_Expection extends IllegalArgumentException{
    Invalid_Expection(String exception_name){
        super(exception_name);
    }
}
