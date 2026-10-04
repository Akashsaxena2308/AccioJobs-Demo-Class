package org.example.BankApplication;

public interface Bank_Interface{
    String check_Balance(String password);
    String add_money(int amount);
    String changePassword(String str); // NEED TO BE IMPLEMENTED
    String withDrawMoney(String password, int amount);
    String getBankName();
    int getInterest();
    double calculate_interest(int year);
    void receipt(String password);
}
