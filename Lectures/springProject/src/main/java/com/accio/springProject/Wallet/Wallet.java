package com.accio.springProject.Wallet;

public class Wallet {

    private int balance; //STATIC --> 2nd wallet

    public Wallet(int balance){
        if(balance<0){
            throw new IllegalArgumentException("Balance cannot be negative!");
        }

        this.balance = balance;
    }

    public synchronized boolean withdraw(int amount){
        if(amount<=0){
            throw new IllegalArgumentException("Amount must be positive!");
        }

        if(amount > balance){
            return false;
        }

        balance-=amount;
        return true;
    }

    public synchronized int getBalance(){
        return balance;
    }

}


//Bank
// Year end trip -- Bike -- Goal
//POT --> 10k
//POT --> 20k

// One Application - Paytm  || Jupiter Money || FiMoney
// Bank account
// Bank to Wallet
// Pots --> Pot1 , Pot2, Pot3
