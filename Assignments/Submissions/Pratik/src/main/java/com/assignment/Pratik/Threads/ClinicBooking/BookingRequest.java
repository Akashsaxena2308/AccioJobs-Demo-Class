package com.assignment.Pratik.Threads.ClinicBooking;

public class BookingRequest {
    private final String slotId;
    private final String patientId;

    public BookingRequest(String slotId, String patientId){
        this.slotId = slotId;
        this.patientId = patientId;
    }

    public String getSlotId(){
        return slotId;
    }

    public String getPatientId(){
        return patientId;
    }
}
