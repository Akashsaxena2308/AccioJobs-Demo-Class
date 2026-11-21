package com.accio.springProject.JpaMovies;

import lombok.Builder;

@Builder
public record MovieResponse(
        Long id,
        String name,
        int time,
        double rating
) {
}
