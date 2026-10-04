package org.example.BankApplication;

import java.util.Scanner;

public class SBI extends Bank_Account {
    public SBI(String name, String password, int balance){
        super(name, password, balance);
    }

    public String getBankName(){
        return "SBI";
    }

    public int getInterest(){
        return 6;
    }

}
