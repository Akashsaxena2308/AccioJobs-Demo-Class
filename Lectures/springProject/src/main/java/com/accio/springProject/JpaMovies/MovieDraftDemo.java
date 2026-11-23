package com.accio.springProject.JpaMovies;

public class MovieDraftDemo {

    public static void main(String[] args){

        MovieDraft draft = new MovieDraft(); //No Args Constructor
        draft.setName("Movie 1");  //Setter
        draft.setTime(5); //Setter

        System.out.println(draft.getName());
    }
}
