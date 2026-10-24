package com.accio.springProject.watchlist;

public class MovieError {
    private final String message;

    public MovieError(String message) { this.message = message; }
    public String getMessage() { return message; }
}
