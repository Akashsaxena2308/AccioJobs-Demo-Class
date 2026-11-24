package com.accio.springProject.JpaLibrary;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lib19_shelf_positions")
@Getter
@NoArgsConstructor
public class ShelfPosition {

    @EmbeddedId
    private ShelfPositionId id;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false, unique = true)
    private LibraryBook book;

}
