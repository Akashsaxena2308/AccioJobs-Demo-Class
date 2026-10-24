package BankApplication;
import java.util.UUID;

public abstract class BankAccount implements BankInterface {
    private final String name;
    private final String accountNo;
    private int balance;
    private String password;
    BankAccount(String name, String password, int balance){
        this.name = name;
        this.accountNo = UUID.randomUUID().toString();
        this.balance = balance;
        this.password = password;
    }
    public int checkBalance(String password){
        if(!this.password.equals(password)){
            throw new IllegalArgumentException("Access denied: Incorrect password");
        }
        return balance;
    }
    public String addMoney(int money) throws IllegalArgumentException{
        if(money <= 0){
            throw new IllegalArgumentException("Deposite must be positive");
        }
        if(money > Integer.MAX_VALUE - money){
            throw new IllegalArgumentException("Deposite must be positive");
        }
        balance += money;
        return "Deposited : " + money;
    }

    String addMoney(int money, int note){
        System.out.println();
        return "Notes used: " + note + " " + addMoney(money);
    }

    void changePassword(String oldPassword, String newPassword){
        if(!this.password.equals(oldPassword)){
            throw new IllegalArgumentException("Incorrect password entered");
        }
        if(newPassword==null || newPassword.isBlank()){
            throw new IllegalArgumentException("Password must not be null");
        }

        this.password = newPassword;
            System.out.println("Password changed");
    }

    public String withDrawMoney(int money, String password){
        if(!this.password.equals(password)){
            throw new IllegalArgumentException("Incorrect password");
        }
        if(money > balance){
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= money;
        return "withdraw: " + money +  "final balance: " + balance;
    }


    public String getName() {
        return name;
    }

//    get bank name method
//    number of years as input and calculates interest

    public abstract String getBankName();

    public abstract int getInterestRate();

    public double calculateInterestAfterYears(int years){
        if(years <= 0){
            return -1;
        }
        return balance * getInterestRate()*years /100;
    }

//    public String getAccountNo() {
//        return accountNo;
//    }
}
