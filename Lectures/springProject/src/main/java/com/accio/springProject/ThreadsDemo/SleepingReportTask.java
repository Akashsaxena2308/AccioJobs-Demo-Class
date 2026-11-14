package com.accio.springProject.ThreadsDemo;

public class SleepingReportTask implements Runnable {

    private final long milliSec;

    public SleepingReportTask(long milliSec){
        this.milliSec = milliSec;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sleeping task finished executing! "
                + Thread.currentThread().getName());
    }
}
