package com.assignment.Pratik.Threads.basicexample;

public class Client {
    public static void main(String args[]){
        System.out.println("I am the main class");
        ScalerThread add_thread = new ScalerThread(new Adder());
        ScalerThread sub_thread = new ScalerThread(new Subractor());

        add_thread.start();
        sub_thread.start();
    }
}
