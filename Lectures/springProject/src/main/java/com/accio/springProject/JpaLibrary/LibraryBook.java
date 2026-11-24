package com.accio.springProject.JpaLibrary;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lib19_books")
@Getter
@NoArgsConstructor
public class LibraryBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToMany
    @JoinTable(name = "lib19_book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @OrderBy("id ASC")
    private Set<LibraryAuthor> authors = new HashSet<>();
}
