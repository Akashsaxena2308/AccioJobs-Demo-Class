package com.accio.springProject.ThreadsDemo;

public class WorkerTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Worker Task is being executed!"
                + Thread.currentThread().getName());
    }
}
