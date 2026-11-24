package com.accio.springProject.JpaLibrary;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShelfPositionId {

    @Column(name = "room_code")
    private String roomCode;

    @Column(name = "position_no")
    private Integer position;
}
// COMPOSITE PRIMARY KEY
// VIEW --> OBJECT --> USER REPONSE

// ENTITIES --> TABLE CONNECTION
