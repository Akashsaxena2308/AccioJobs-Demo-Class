package com.assignment.Pratik.Threads.Wallet;

public class Wallet {
    private int balance;

    public Wallet(int balance){
        if (balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.balance = balance;
    }

    public synchronized boolean withdraw(int amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be positive!");
        }

        if (amount > balance){
            return false;
        }

        balance -= amount;
        return true;
    }

    public synchronized int getBalance(){
        return balance;
    }
}
