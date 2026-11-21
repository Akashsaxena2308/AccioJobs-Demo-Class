package com.accio.springProject.JpaMovies;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByRatingAndTimeGreaterThanEqualOrderByIdAsc(
            double rating, int time);
}


// SELECT * FROM movie_db WHERE id = ? -----> Normal SQL

//

// []
// 8 Ratings and time > 300 mins

// Find movies by Rating and time greater than Given value and order then in ASC order

// findByRatingsAndTimeGreaterThanEqualOrderByAsc(double rating, int time)

// JPA Repository

// 1. LIST CRUD REPOSITORY ---> CRUD

// 2. LIST PAGING AND SORTING REPOSTIORY --> PAGINATION AND SORTING

// 3.QUERY BY EXAMPLE EXECUTOR ---> Derived queries
