package com.accio.springProject;

public class Song {
    String title;
    Double duration;

    Song(String title, Double duration){
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public Double getDuration() {
        return duration;
    }
}
