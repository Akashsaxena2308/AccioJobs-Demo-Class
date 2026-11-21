package com.accio.springProject.JpaMovies;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository){ //Constructor Injection
        this.repository = repository;
    }



    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Movie findById(Long id){
        return  repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public Movie create(MovieInput input){
        return repository.save(new Movie(input.name(), input.time(), input.rating()));
    }

    @Transactional
    public Movie update(Long id, MovieInput input) {
        Movie movie = findById(id); //Finds existing movie in database
        movie.changeDetails(input.name(), input.time(), input.rating());
        return repository.save(movie);
    }

    public void delete(Long id){
        Movie movie = findById(id);
        repository.delete(movie);
    }


    public List<Movie> suitable(double rating, int time){
        return repository.findByRatingAndTimeGreaterThanEqualOrderByIdAsc(rating, time);
    }
}