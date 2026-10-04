package org.example.BankApplication;

import java.util.UUID;

abstract class Bank_Account implements Bank_Interface{
    private final String name;
    private final String account_no;
    private String password;
    private int balanace;

    Bank_Account(String name, String password, int balance){
        this.name = name;
        this.password = password;
        this.balanace = balance;
        this.account_no = UUID.randomUUID().toString();
    }

    public String check_Balance(String password){
        if (!this.password.equals(password)){
            return "Please enter correct password";
        }

        return "Account has :- " + balanace;
    }

    public String add_money(int amount){
        if(amount > 0 && this.balanace < Integer.MAX_VALUE -amount){
            return "Money added : "+this.balanace;
        }

        return "Please Enter the correct Amount";
    }

    public String changePassword(String str){
        if(str == null || str.isBlank()){
            return "Please Enter the correct Password ";
        }

        if (str == this.password){
            return "Please Enter the new password ";
        }

        return this.password = str;
    }

    public String withDrawMoney(String password, int amount){
        if(!this.password.equals(password)){
            return "Incorrect password";
        }

        if(amount > this.balanace){
            return "Insufficient balance";
        }

        balanace = balanace -amount;

        return "withdraw : " + balanace;
    }

    public String getBankName(){
        return "Some generic Bank";
    }

    public int getInterest(){
        return 0;
    }

    public double calculate_interest(int year){
        if (year <= 0){
            return -1;
        }

        return (double) balanace*getInterest();
    }

    public String getAccount_no() {
        return account_no;
    }

    public String getName() {
        return name;
    }

    public void receipt(String password){
        if (password.equals(this.password)){
            System.out.println("Account Holder : " + getName());
            System.out.println("Account Number : " + getAccount_no());
            System.out.println("Bank Name : "+getBankName());
            System.out.println("Available : "+check_Balance(password));
            System.out.println("Withdraw money : "+withDrawMoney(password, 10000));
            System.out.println(add_money(10000));
        }else {
            System.out.println("Please enter the correct password");
        }
    }
}
