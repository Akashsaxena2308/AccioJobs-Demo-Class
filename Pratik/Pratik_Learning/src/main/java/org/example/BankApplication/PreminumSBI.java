package org.example.BankApplication;

public class PreminumSBI extends SBI{
    PreminumSBI(String name, String password, int balance){
        super(name, password, balance);
    }

    public String getBankName(){
        return "Premium SBI";
    }

    public int getInterestRate(){
        return (int)(super.getInterest() + 1.5);
    }
}
