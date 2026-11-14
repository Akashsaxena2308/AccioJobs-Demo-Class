package com.accio.springProject.ThreadsDemo;

public class Counter {

    private int value = 0;

    public void increment(){
        synchronized (this) {
            value++;
        }
    }

    public synchronized int getValue(){
        return value;
    }
}
