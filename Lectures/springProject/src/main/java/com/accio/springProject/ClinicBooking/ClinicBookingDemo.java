package com.accio.springProject.ClinicBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClinicBookingDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AppointmentSlot morning = new AppointmentSlot("MORNING", 2);
        AppointmentSlot afternoon = new AppointmentSlot("AFTERNOON", 1);

        ClinicBookingService service = new ClinicBookingService(morning, afternoon);

        List<BookingRequest> requests = List.of(
                new BookingRequest("MORNING", "p1"),
                new BookingRequest("MORNING", "p2"),
                new BookingRequest("MORNING", "p1"),
                new BookingRequest("AFTERNOON", "p4"),
                new BookingRequest("AFTERNOON", "p5")
        );

        int booked = 0;
        int full = 0;

        //THREAD POOL [2] --> Worker 2 --> 5 task
        // GROUP of THREADS
        // THREAD --> EXECUTE A WORKER/TASK

        try(ExecutorService pool = Executors.newFixedThreadPool(2)){
            List<Future<BookingResult>> results = new ArrayList<>();

            for(BookingRequest request : requests){
                results.add(pool.submit(() -> service.book(request)));
            }

            for(int index = 0; index < results.size(); index++){
                BookingRequest request = requests.get(index);
                BookingResult result = results.get(index).get();

                System.out.println(request.getSlotId() + " "
                        + request.getPateintId() + " "
                        + result);

                if(result == BookingResult.BOOKED){
                    booked++;
                }
                else if(result == BookingResult.FULL){
                    full++;
                }
            }
        }

        System.out.println("Booked = " + booked + " , FULL = " + full);
        System.out.println("Morning remaining " + morning.getRemainintSeats());
        System.out.println("Afternoon remaining " + afternoon.getRemainintSeats());
    }
}
