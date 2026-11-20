package com.assignment.Pratik.Threads.addersubtractorproblemusingrunnableandstart;

import com.assignment.Pratik.Threads.addersubstractorusingcallableandexcutor.Substractor;

public class Subtractor implements Runnable{
    private final Count count;
    public Subtractor(Count count){
        this.count = count;
    }

    public void run(){
        for (int i = 0; i <= 10_000; i++){
            synchronized (count){
                count.val -= i;
            }
        }
    }
}
