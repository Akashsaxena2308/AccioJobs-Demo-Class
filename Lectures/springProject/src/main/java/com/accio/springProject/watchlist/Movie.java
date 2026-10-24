package com.accio.springProject.watchlist;

// WALKTHROUGH 1: the response contains the server-generated ID.
// Immutable fields let PUT replace the whole object after validation succeeds.
public class Movie {
    private final long id;
    private final String title;
    private final int releaseYear;

    public Movie(long id, String title, int releaseYear) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public int getReleaseYear() { return releaseYear; }
}
