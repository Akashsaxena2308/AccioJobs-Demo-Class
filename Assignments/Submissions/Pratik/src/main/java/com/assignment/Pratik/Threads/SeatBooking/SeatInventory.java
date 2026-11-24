package com.assignment.Pratik.Threads.SeatBooking;

public class SeatInventory {
    private int remainingSeats;

    public SeatInventory(int remainingSeats){
        if (remainingSeats < 0){
            throw new IllegalArgumentException("Seats cannot be negative");
        }
        this.remainingSeats = remainingSeats;
    }

    public synchronized boolean bookOneSeat(){
        if (remainingSeats == 0){
            return false;
        }

        remainingSeats--;
        return true;
    }

    public synchronized int getRemainingSeats(){
        return remainingSeats;
    }
}
