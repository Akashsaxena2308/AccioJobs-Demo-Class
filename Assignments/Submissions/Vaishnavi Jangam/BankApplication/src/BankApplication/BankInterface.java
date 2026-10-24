package BankApplication;

public interface BankInterface {
    int checkBalance(String password);
    String addMoney(int money);
    String withDrawMoney(int money, String password);
    String getBankName();
    int getInterestRate();

}
