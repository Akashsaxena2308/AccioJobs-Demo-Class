package com.accio.springProject.JpaLibrary;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lib19_students")
@Getter
@NoArgsConstructor
public class LibraryStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "card_id", nullable = false, unique = true)
    private LibraryCard card;

    @OneToMany(mappedBy = "libraryStudent")
    @OrderBy("id ASC")
    private List<LibraryLoan> loans = new ArrayList<>();
}
