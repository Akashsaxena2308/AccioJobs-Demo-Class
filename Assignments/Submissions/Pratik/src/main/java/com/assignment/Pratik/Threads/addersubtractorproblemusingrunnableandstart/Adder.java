package com.assignment.Pratik.Threads.addersubtractorproblemusingrunnableandstart;

public class Adder implements Runnable{
    private final Count count;
    public Adder(Count count){
        this.count = count;
    }

    public void run(){
        for(int i = 0; i <= 10_000; i++){
            synchronized(count){
                count.val += i;
            }
        }
    }
}
