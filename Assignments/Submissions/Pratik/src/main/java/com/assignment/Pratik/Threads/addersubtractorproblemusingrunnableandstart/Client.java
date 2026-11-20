package com.assignment.Pratik.Threads.addersubtractorproblemusingrunnableandstart;


import com.assignment.Pratik.Threads.addersubtractorproblemusingrunnableandstart.Subtractor;

public class Client {
    public static void main(String args[]) throws InterruptedException {
        Count cnt = new Count();

        Adder adder = new Adder(cnt);
        Subtractor subtractor = new Subtractor(cnt);

        Thread thread = new Thread(adder);
        Thread thread2 = new Thread(subtractor);

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println(cnt.val);
    }
}
