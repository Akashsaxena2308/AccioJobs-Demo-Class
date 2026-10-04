package org.example.BankApplication;

public class HDFC extends Bank_Account{
    public HDFC(String name, String password, int balance){
        super(name, password, balance);
    }

    public String getBankName(){
        return "HDFC";
    }

    public int get_interest_rate(){
        return 7;
    }

}
