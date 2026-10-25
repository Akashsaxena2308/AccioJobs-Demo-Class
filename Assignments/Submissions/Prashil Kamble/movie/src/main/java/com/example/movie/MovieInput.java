package com.example.movie;

public class MovieInput {

    String name;
    Integer releaseYear;
    double duration;

//    public MovieInput(String name, Integer releaseYear, double duration){
//        this.name = name;
//        this.releaseYear = releaseYear;
//        this.duration = duration;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int setId(int id){
        return id;
    }

}
