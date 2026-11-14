package com.accio.springProject.ThreadsDemo;

public class DeadlockDemo {

    public static void main(String[] args) throws InterruptedException {

        Object printer = new Object();
        Object scanner = new Object();

        Thread harry = new Thread(() -> useDevice(printer, scanner), "harry");
        Thread hermoine = new Thread(() -> useDevice(printer, scanner), "hermoine");


//        harry.setDaemon(true);
//        hermoine.setDaemon(true);

        harry.start();
        hermoine.start();

        harry.join(1_000);
        hermoine.join(1_000);

        System.out.println("Main method executed!");
    }


    private static void useDevice(Object obj1, Object obj2){
        String name =  Thread.currentThread().getName();

        synchronized (obj1) {
            System.out.println("Acquired Object : " + name + " " + obj1);

            try {
                Thread.sleep(1000);
                //OBJECT 1 WORK [Printer / Scanner]
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (obj2) {
                System.out.println("Acquired Object " + name + " " + obj2);
            }
        }
    }

}





