package com.accio.springProject.JpaMovies;

public record RatingSummary (
        Double rating,
        Long totalMovies,
        Long totalRuntime
) {
}
