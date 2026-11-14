package com.accio.springProject.ThreadsDemo;

public class SingletonDemo {

    public static void main(String[] args) throws InterruptedException {
//        AppSettings settings1 = AppSettings.getInstance();
//        AppSettings settings2 = AppSettings.getInstance();
//
//        System.out.println("Same object : "
//                + (settings1 == settings2));
//

        AppSettings[] results = new AppSettings[2];

        Thread worker1 = new Thread(() -> {
            results[0] = AppSettings.getInstance();
        },"Worker 1");
        Thread worker2 = new Thread(() -> {
            results[1] = AppSettings.getInstance();
        }, "Worker 2");

        worker1.start();
        worker2.start();

        worker1.join();
        worker2.join();

        System.out.println("Same object : "
                + (results[0] == results[1]));

    }


}
