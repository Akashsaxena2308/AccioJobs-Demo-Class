package com.accio.springProject.SeatBooking;

public class SeatInventory {
    private int remainingSeats;

    public SeatInventory(int remainingSeats){
        if(remainingSeats<0){
            throw new IllegalArgumentException("Seats cannot be negative!");
        }

        this.remainingSeats = remainingSeats;
    }


    public synchronized boolean bookOneSeat(){
        if(remainingSeats == 0){ //Checks if seat is available
            return false;
        }

        remainingSeats--; //Books the seat
        return true;
    }

    public synchronized  int getRemainingSeats(){
        return remainingSeats;
    }

}

// Static --> same value shared between all objects
// Bus 1 --> 10
// Bus 2 --> 10

// Bus 1 --> 10
// Bus 2 --> 50


//SYSTEM --> 2 API ? 2 Request?
//Phone --> Book --> Both click book at same time
//2 API call --> reaches our service at same time
//CPU decide --> 2 threads --> Random

// T1 --> Processing --> T1 wait --> DB update
// T2 --> Computation --> 2*2

//Booking
// --> Checking if seat is available -- synchronised - T1 --> 1, T2 --> 1
// AND Booking the seat

// Checking if seat is available and booking should be done together

//2 User --> Book
// 2 API --> To book seat
// Booking service --> 2 threads --> Request process
// 1 available [RACE condition]
// Booking start
// Payment --> Both threads show seats as booked --> Logic incorrect
