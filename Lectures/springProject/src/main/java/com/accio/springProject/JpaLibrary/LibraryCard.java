package com.accio.springProject.JpaLibrary;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lib19_cards")
@Getter
@NoArgsConstructor
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique = true)
    private String code;

    @OneToOne(mappedBy = "card")
    private LibraryStudent student;

    public LibraryCard (String cardCode){
        this.code = cardCode;
    }

    public void assignTo(LibraryStudent student){
        this.student = student;
    }

}
