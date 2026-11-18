package com.accio.springProject.ClinicBooking;

import java.time.DayOfWeek;

public class BookingRequest {

    private final String slotId;
    private final String pateintId;

    public BookingRequest(String slotId, String pateintId){
        this.slotId = slotId;
        this.pateintId = pateintId;
    }

    public String getSlotId() {
        return slotId;
    }

    public String getPateintId(){
        return pateintId;
    }
}
//Class --> ABC
// slotId --> static
// ABC obj1 -- slot1
// ABC obj2 -- slot1


// Class --> ABC
// slotId --> final
// ABC obj1 --> slotId = 1 --> HEAP
// obj1.slotId = 2 --> THIS IS NOT ALLOWED
// ABC obj2 --> slotId = 1 --> HEAP

// Obj a = { "slotId" : 1 }
// a.slotId = 2; ERROR


// class --> final --> extend --> INHERITANCE
// object --> final --> reference will be final

// final Wallet wallet = new Wallet(1000);
// Heap --> Exist
// Stack --> Address

// variable --> final
//