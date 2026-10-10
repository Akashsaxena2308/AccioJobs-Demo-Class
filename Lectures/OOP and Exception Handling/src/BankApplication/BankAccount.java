package BankApplication;

import java.util.UUID;

public abstract class BankAccount implements BankInterface {
    private final String name;
    private final String accountNo;
    private String password;
    private int balance;

    protected BankAccount(String name, String password, int balance) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password must not be blank");
        }
        if (balance < 0) {
            throw new InvalidAmountException("Opening balance cannot be negative");
        }
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo = UUID.randomUUID().toString();
    }

    private void verifyPassword(String suppliedPassword) {
        if (!password.equals(suppliedPassword)) {
            throw new SecurityException("Incorrect password entered");
        }
    }

    @Override
    public int checkBalance(String password) {
        verifyPassword(password);
        return balance;
    }

    @Override
    public String addMoney(int money) {
        // Unchecked exceptions do not require a throws declaration.
        if (money <= 0) {
            throw new InvalidAmountException("Deposit must be positive");
        }
        if (money > Integer.MAX_VALUE - balance) {
            throw new InvalidAmountException("Deposit would exceed the balance limit");
        }
        balance += money;
        return "Deposited: " + money;
    }

    public String addMoney(int money, int note) {
        if (note <= 0) {
            throw new InvalidAmountException("Note denomination must be positive");
        }
        // Delegate validation to the first overload; let the caller handle failure.
        return "Note denomination: " + note + ". " + addMoney(money);
    }

    public String getName() {
        return name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String changePassword(String oldPassword, String newPassword) {
        verifyPassword(oldPassword);
        if (newPassword == null || newPassword.isBlank()) {
            throw new IllegalArgumentException("New password must not be blank");
        }
        password = newPassword;
        return "Password changed";
    }

    @Override
    public String withDrawMoney(int money, String password) throws InsufficientFundsException {
        verifyPassword(password);
        if (money <= 0) {
            throw new InvalidAmountException("Withdrawal must be positive");
        }
        if (money > balance) {
            // throw creates the failure; throws declares it to the caller.
            throw new InsufficientFundsException(
                    "Requested " + money + ", but available balance is " + balance);
        }
        // Update only after every check passes. A failed withdrawal changes nothing.
        balance -= money;
        return "Withdrawn: " + money + ". Final balance: " + balance;
    }

    @Override
    public abstract String getBankName();

    @Override
    public abstract int getInterestRate();

    public double calculateInterestAfterYears(int years) {
        if (years <= 0) {
            throw new IllegalArgumentException("Years must be positive");
        }
        // Convert before multiplication to avoid overflowing an int intermediate.
        return (double) balance * getInterestRate() * years / 100;
    }
}
