package com.accio.springProject.JpaMovies;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public MovieResponse toResponse(Movie movie){
        return MovieResponse.builder()
                .id(movie.getId())
                .name(movie.getName())
                .time(movie.getTime())
                .rating(movie.getRating())
                .build();
    }

    public List<MovieResponse> toResponse(List<Movie> movies){
        List<MovieResponse> movieResponses = new ArrayList<>();

        for(Movie m : movies) {
            movieResponses.add(toResponse(m));
        }

        return movieResponses;
    }
}
