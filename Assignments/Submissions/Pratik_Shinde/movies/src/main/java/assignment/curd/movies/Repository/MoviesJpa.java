package assignment.curd.movies.Repository;

import assignment.curd.movies.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoviesJpa extends JpaRepository<Movies, UUID> {
}
