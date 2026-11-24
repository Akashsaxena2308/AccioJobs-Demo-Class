package com.accio.springProject.JpaMovies;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "movie_db")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name="duration_of_movie", nullable = false)
    private int time;

    @Column(nullable = false)
    private double rating;

    public Movie(String name, int time, double rating) {
        this.name = name;
        this.time = time;
        this.rating = rating;
    }

    protected Movie () {

    }

    public void changeDetails(String name, int time, double rating){
        this.name = name;
        this.rating = rating;
        this.time = time;
    }

}


// function a () {
//
// Do something --> Exception --> handled
//
// Code --> JVM will never reach this
//
// }
