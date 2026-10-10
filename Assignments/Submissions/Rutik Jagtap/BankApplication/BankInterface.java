public interface BankInterface {

    int checkBalance(String password);

    void deposite(int amount);

    void withdraw(int amount, String password);

    int changePassword(String oldPassword, String newPassword);

    String getBankName();

    double getInterestRate();

    double calculateInterestAfterYear(int year);
}