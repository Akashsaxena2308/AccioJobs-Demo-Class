package BankApplication;

public interface BankInterface {
    int checkBalance(String password) throws Invalid_Expection;
    String addMoney(int money) throws Invalid_Expection;
    String withDrawMoney(int money, String password);
    String getBankName();
    int getInterestRate();
}
