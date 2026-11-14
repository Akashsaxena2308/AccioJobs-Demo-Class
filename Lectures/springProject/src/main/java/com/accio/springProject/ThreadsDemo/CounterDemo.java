package com.accio.springProject.ThreadsDemo;

public class CounterDemo {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable counterTask = () -> {
            for(int i = 0; i < 100_000; i++){
                counter.increment();
            }
        };

        Thread first = new Thread(counterTask, "First");
        Thread second = new Thread(counterTask, "Second");

        first.start();

        second.start();

        first.join();

        second.join();

        System.out.println("Final value of counter after tasks "
                + counter.getValue());
    }
}

