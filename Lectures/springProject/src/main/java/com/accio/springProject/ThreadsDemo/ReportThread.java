package com.accio.springProject.ThreadsDemo;

public class ReportThread extends Thread {

    @Override
    public void run(){
        System.out.println( "Worker: Report finished on" +
                Thread.currentThread().getName());
    }
}
