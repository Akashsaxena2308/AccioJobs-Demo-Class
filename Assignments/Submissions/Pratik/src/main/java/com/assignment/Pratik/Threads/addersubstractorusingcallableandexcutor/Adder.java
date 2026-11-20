package com.assignment.Pratik.Threads.addersubstractorusingcallableandexcutor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Count count;

    public Adder(Count count){
        this.count = count;
    }

    public Void call() throws Exception{
        for (int i = 1; i <= 10000; i++){
            count.val += i;
        }
        return null;
    }
}
