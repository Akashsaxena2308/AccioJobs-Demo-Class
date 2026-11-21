package com.accio.springProject.JpaMovies;

import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieResponse toResponse(Movie movie){
        return MovieResponse.builder()
                .id(movie.getId())
                .name(movie.getName())
                .build();
    }
}
