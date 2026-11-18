package com.accio.springProject.SeatBooking;

public class BookingDemo {

    public static void main(String[] args) throws InterruptedException {
        SeatInventory inventory = new SeatInventory(1);
        boolean[] booked = new boolean[2];

        Thread first = new Thread(
                () -> booked[0] = inventory.bookOneSeat(),
                "Worker 1"
        );

        Thread second = new Thread(
                () -> booked[1] = inventory.bookOneSeat(),
                "Worker 2"
        );

        first.start(); // Thread --> processing --> CPU
        second.start(); // Thread --> processing --> CPU

        first.join();
        second.join();

        System.out.println("Worker 1 booked : " + booked[0]);
        System.out.println("Worker 2 booked : " + booked[1]);
        System.out.println("Seats remaining : " +  inventory.getRemainingSeats());
    }
}
