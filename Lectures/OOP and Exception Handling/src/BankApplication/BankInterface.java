package BankApplication;

public interface BankInterface {
    int checkBalance(String password);
    String addMoney(int money);

    // The interface must declare the checked exception too.
    String withDrawMoney(int money, String password)  throws InsufficientFundsException;

    String getBankName();
    int getInterestRate();

}
