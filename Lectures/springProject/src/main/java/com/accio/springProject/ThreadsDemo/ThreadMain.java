package com.accio.springProject.ThreadsDemo;

public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
        ReportThread worker1 = new ReportThread();

        worker1.setName("Worker 1");
//        worker.run();
        System.out.println("Main thread has finished!" +
                Thread.currentThread().getName());

        WorkerTask task1 = new WorkerTask();
        Thread worker2 = new Thread(task1, "Worker 2");

        SleepingReportTask task2 = new SleepingReportTask(2_000);
        Thread worker3 = new Thread(task2, "Worker 3");
        Thread worker4 = new Thread(task2, "Worker 4");

        worker3.start();
//        worker3.join();

        worker1.start();

        worker2.start();
//        worker4.start();
        worker3.join();

//        worker1.start();

        //Worker thread --> Tasks --> run()

        System.out.println("Print after thread timeouts");

    }
}

// NEW

// RUNNABLE

// TIMED_WAITING

// WAITING

// BLOCKED

// TERMINATED


//Counter --> count

// Two threads --> count + 1000000