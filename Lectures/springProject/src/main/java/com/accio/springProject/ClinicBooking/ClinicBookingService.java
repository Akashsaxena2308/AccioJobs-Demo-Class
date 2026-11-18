package com.accio.springProject.ClinicBooking;

import java.util.Map;

public class ClinicBookingService {

    private final Map<String, AppointmentSlot> slots;

    public ClinicBookingService(AppointmentSlot morning, AppointmentSlot afternoon){
        slots = Map.of(
                morning.getId(), morning,
                afternoon.getId(), afternoon
        );
    }

    public BookingResult book(BookingRequest request){
        if(request == null
        || request.getSlotId() == null
        || request.getSlotId().isBlank()
        || request.getPateintId() == null
        || request.getPateintId().isBlank()){
            return BookingResult.INVALID_REQUEST;
        }

        AppointmentSlot slot = slots.get(request.getSlotId());

        if(slot == null){
            return BookingResult.SLOT_NOT_FOUND;
        }

        return slot.book(request.getPateintId());
    }



}
