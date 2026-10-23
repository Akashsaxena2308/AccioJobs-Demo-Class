package com.example.movie;

public class Movie {

    int id;
    String name;
    Integer releaseYear;
    double duration;

    public Movie(int id, String name, Integer releaseYear, double duration){
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Integer getReleaseYear(){
        return releaseYear;
    }

    public double getDuration(){
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

}
