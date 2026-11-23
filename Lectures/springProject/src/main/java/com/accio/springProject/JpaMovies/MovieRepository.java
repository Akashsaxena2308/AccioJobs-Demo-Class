package com.accio.springProject.JpaMovies;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByRatingGreaterThanEqualAndTimeGreaterThanEqualOrderByIdAsc(
            double rating, int time);

    List<Movie> findByNameContainingIgnoreCaseOrderById(String name);


    @Query("SELECT m FROM Movie m WHERE m.rating >= :rating AND m.time >= :time")
    List<Movie> findByRatingAndTimeUsingJPQL(double rating, int time, Pageable pagination);

    @Query(value = "SELECT * FROM movie_db m WHERE m.rating >= ? AND m.duration_of_movie >= ? " +
            "ORDER BY m.id", nativeQuery = true)
    List<Movie> findByRatingAndTimeUsingSQL(double rating, int time);

    @Query("SELECT m.rating AS rating, COUNT(m) AS totalCount, SUM(m.time) AS totalRuntime " +
            "FROM Movie m GROUP BY m.rating ORDER BY m.rating")
    List<RatingSummary> findRatingSummary();
}



// SELECT * FROM movie_db m WHERE m.rating >= ? AND m.duration_of_movie >= ?
// ORDER BY id;


//JPQL --> Java Persistence Query Language
//

// SELECT m FROM Movie m WHERE m.rating >= :rating AND m.time >= :time
// ORDER BY id;

//
// findByNameContainingIgnoreCaseOrderById(string name); --> findByRating --> equals / equal to
// Return list of movies containing a given name and ordered by ID

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
