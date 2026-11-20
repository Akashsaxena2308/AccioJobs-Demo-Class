package com.assignment.Pratik.Threads.ClinicBooking;

import java.util.HashSet;
import java.util.Set;

public class AppointmentSlot {
    private final String id;
    private final int capacity;
    private final Set<String> patients = new HashSet<>();

    public AppointmentSlot(String id, int capacity){
        if (id == null || id.isBlank() || capacity < 0){
            throw new IllegalArgumentException("A slot needs an ID and positive capacity!");
        }
        this.id = id;
        this.capacity = capacity;
    }

    public synchronized BookingResult book(String patientId){
        if (patientId == null || patientId.isBlank()){
            return BookingResult.INVALID_REQUEST;
        }

        if (patients.contains(patientId)){
            return BookingResult.ALREADY_BOOKED;
        }

        if(patients.size() == capacity){
            return BookingResult.FULL;
        }

        patients.add(patientId);
        return BookingResult.BOOKED;
    }

    public String getId(){
        return id;
    }

    public synchronized int getRemainingSeats(){
        return capacity -patients.size();
    }
}
