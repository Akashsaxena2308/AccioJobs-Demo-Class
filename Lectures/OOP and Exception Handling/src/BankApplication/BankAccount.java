package BankApplication;

import java.util.UUID;

public abstract class BankAccount implements BankInterface {
    private final String name;
    private final String accountNo;
    private String password;
    private int balance;

    BankAccount(String name, String password, int balance){
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo = UUID.randomUUID().toString();
    }


    public int checkBalance(String password){
        if(!this.password.equals(password)){
            return -1;
        }

        return balance;
    }

    public String addMoney(int money){
        if(money <= 0){
            return "Deposit must be postive value!";
        }
        if(balance > Integer.MAX_VALUE - money){
            return "Balance Limit Exceeded!";
        }

        balance+=money;

        return "Deposited :" + money;
    }

    public String addMoney(int money, int note){
        System.out.println();
        return "Notes used : " + note + " " + addMoney(money);
    }

    public String getName() {
        return name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String changePassword(String oldPassword, String newPassword){
        if(!this.password.equals(oldPassword)){
            return "Incorrect password entered!";
        }
        if(newPassword==null || newPassword.isBlank()){
            return "New password must not be blank!";
        }

        this.password = newPassword;
        return "Password changed!";
    }

    public String withDrawMoney(int money, String password){
        if(!this.password.equals(password)){
            return "Incorrect password entered!";
        }
        if(money > balance){
            return "Insufficient funds!";
        }

        balance-=money;
        return "Withdrawn :" +  money + " Final balance :" + balance;
    }

    //Get Bank name method
    //Number of years as input and calculates interest

    public abstract String getBankName();

    public abstract int getInterestRate();

    public double calculateInterestAfterYears(int years){
        if(years<=0){
            return -1;
        }

        return (double) balance * getInterestRate()*years / 100;
    }
}
