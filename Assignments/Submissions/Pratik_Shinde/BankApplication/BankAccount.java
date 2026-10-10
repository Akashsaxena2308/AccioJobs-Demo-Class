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


    public int checkBalance(String password) throws Invalid_Expection{
        if(!this.password.equals(password)){
            throw new Invalid_Expection("Invalid password");
        }

        return balance;
    }

    public String addMoney(int money) throws Invalid_Expection{
        if(money <= 0){
            throw new Invalid_Expection("Enter valid amount");
        }

        if(balance > Integer.MAX_VALUE - money){
            throw new Invalid_Expection("Balance Limit Exceeded!");
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

    public String changePassword(String oldPassword, String newPassword) throws Invalid_Expection{
        if(!this.password.equals(oldPassword)){
            throw new Invalid_Expection("Incorrect password entered!");
        }
        if(newPassword==null || newPassword.isBlank()){
            throw new Invalid_Expection("Incorrect password entered!");
        }

        this.password = newPassword;
        return "Password changed!";
    }

    public String withDrawMoney(int money, String password) throws Invalid_Expection{
        if(!this.password.equals(password)){
            throw new Invalid_Expection("Please enter correct password");
        }
        if(money > balance){
            throw new Invalid_Expection("Inefficient balance");
        }

        balance-=money;
        return "Withdrawn :" +  money + " Final balance :" + balance;
    }

    //Get Bank name method
    //Number of years as input and calculates interest

    public abstract String getBankName();

    public abstract int getInterestRate();

    public double calculateInterestAfterYears(int years) throws Invalid_Expection{
        if(years<=0){
            throw new Invalid_Expection("Please enter correct year");
        }

        return (double) balance * getInterestRate()*years / 100;
    }
}
