package com.accio.SpringProject;

public class Song {
    String title;
    double duration;

    Song(String title,double duration){
        this.title = title;
        this.duration = duration;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public double getDuration(){
        return duration;
    }
    public void setDuration(double duration){
        this.duration = duration;
    }
}
