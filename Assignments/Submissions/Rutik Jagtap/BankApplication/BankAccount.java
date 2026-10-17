import java.util.UUID;

public abstract class BankAccount implements BankInterface {

    private final String name;
    private final String accountNo;
    private String password;
    private int balance;

    protected BankAccount(String name, String password, int balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo = UUID.randomUUID().toString();
    }

    @Override
    public int checkBalance(String password) {

        if (!this.password.equals(password)) {
            return -1;
        }

        return balance;
    }

    @Override
    public int changePassword(String oldPassword, String newPassword) {

        if (!this.password.equals(oldPassword)) {
            System.out.println("Password is wrong");
            return -1;
        }

        this.password = newPassword;

        System.out.println("Password changed successfully");

        return 0;
    }

    @Override
    public void deposite(int amount) {

        if (amount <= 0) {
            System.out.println("Amount must be greater than 0");
        }
        else if (balance > Integer.MAX_VALUE - amount) {
            System.out.println("Balance limit exceeded");
        }
        else {
            balance += amount;
            System.out.println("Deposit successful");
        }
    }

    @Override
    public void withdraw(int amount, String password) {

        if (!this.password.equals(password)) {
            System.out.println("Wrong password");
        }
        else if (amount <= 0) {
            System.out.println("Amount must be greater than 0");
        }
        else if (balance < amount) {
            System.out.println("Insufficient balance");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawal successful");
        }
    }

    @Override
    public abstract String getBankName();

    @Override
    public abstract double getInterestRate();

    @Override
    public double calculateInterestAfterYear(int year) {

        if (year <= 0) {
            return -1;
        }

        return (double) balance * getInterestRate() * year / 100;
    }
}