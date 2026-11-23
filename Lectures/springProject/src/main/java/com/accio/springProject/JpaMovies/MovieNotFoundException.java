package com.accio.springProject.JpaMovies;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("Movie " + id + " was not found!");
    }
}
