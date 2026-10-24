package com.accio.springProject.watchlist;

// WALKTHROUGH 1: clients supply details, not the generated ID.
public class MovieInput {
    private String title;
    // Integer lets us distinguish a missing year (null) from a supplied number.
    private Integer releaseYear;

    public MovieInput() { }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
}
