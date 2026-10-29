package assignment.curd.movies.Service;

import assignment.curd.movies.DTO.MoviesDto;
import assignment.curd.movies.Model.Movies;
import assignment.curd.movies.Repository.MoviesJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MoviesService {
    private final MoviesJpa repository;

    public Movies addUser(MoviesDto moviesDto){
        Movies movies = Movies.builder()
                .title(moviesDto.getTitle())
                .date(moviesDto.getDate())
                .build();

        Movies saveduser = repository.save(movies);
        return saveduser;
    }

    public List<Movies> getAllMovies(){
        return repository.findAll();
    }

    public Movies getMovieById(UUID id){
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found with id : "+id)
        );
    }

    public Movies updateMovie(UUID id, MoviesDto moviesDto){
        Movies movies = getMovieById(id);
        movies.setTitle(moviesDto.getTitle());
        movies.setDate(moviesDto.getDate());

        Movies update_movies = repository.save(movies);
        return update_movies;
    }

    public Movies deleteMovieById(UUID id){
        if (id == null){
            throw new IllegalArgumentException("Id does not exists");
        }
        Movies movies = getMovieById(id);
        repository.deleteById(id);
        return movies;
    }
}
