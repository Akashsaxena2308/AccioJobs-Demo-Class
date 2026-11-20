package com.assignment.Pratik.Threads.Wallet;

public class WalletDemo {
    public static void  main(String args[]) throws InterruptedException{
        Wallet wallet = new Wallet(1000);
        boolean booked[] = new boolean[2];

        Thread t1 = new Thread(
                () -> booked[0] = wallet.withdraw(700),
                "Widthdraw balance 1"
        );

        Thread t2 = new Thread(
                () -> booked[1] = wallet.withdraw(700),
                "Widthdraw balance 2"
        );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Withdraw from balance 1 : "+booked[0]);
        System.out.println("Withdraw from balance 2 : "+booked[1]);
        System.out.println("Seat remaining : "+wallet.getBalance());
    }
}
