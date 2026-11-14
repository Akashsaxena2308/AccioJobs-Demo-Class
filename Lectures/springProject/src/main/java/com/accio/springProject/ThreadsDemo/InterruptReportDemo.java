package com.accio.springProject.ThreadsDemo;

public class InterruptReportDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            System.out.println("Worker: Starting report");
            try {
                Thread.sleep(1_000);
                System.out.println("1sec work done!");
                Thread.sleep(5000);
                System.out.println("Worker report : Finished!");
            } catch (InterruptedException e) {
                System.out.println("Worker report : interrupted");
                throw new RuntimeException(e);
            }

        }, "Worker Interrupt Thread");

        worker.start();
        Thread.sleep(2000);
        worker.interrupt();
        worker.join();
        System.out.println("Main: worker has finished!");
    }
}

// thread worker  = new thread(() -> {}, name);
