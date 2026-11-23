package com.accio.springProject.JpaMovies;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/movies")
public class MoviesController {

    private final MovieService service;
    private final MovieMapper mapper;

    public MoviesController(MovieService service, MovieMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public List<Movie> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable("id") Long id){
        return mapper.toResponse(service.findById(id));
    }

    @PostMapping
    public Movie create(@Valid @RequestBody MovieInput input){
        return service.create(input);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable("id") Long id, @Valid @RequestBody MovieInput input){
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping("/suitable")
    public List<MovieResponse> suitable(@RequestParam("rating") double rating,
                                @RequestParam("time") int time){
        return mapper.toResponse(service.suitable(rating, time));
    }

    @GetMapping("/suitableSorted")
    public List<MovieResponse> suitableSorted(@RequestParam("rating") double rating,
                                                @RequestParam("time") int time,
                                              @RequestParam("page") int page,
                                              @RequestParam("size") int size,
                                              @RequestParam("sortBy") String sortBy,
                                              @RequestParam("direction") String direction){
        return mapper.toResponse(service.suitableSort(rating, time, page, size, sortBy, direction));
    }

    @GetMapping("/ratingSummary")
    public List<RatingSummary> getRatingSummary(){
        return service.findRatingSummary();
    }


}


// Rating --> Rating Summary

// Rating --> Total Number of Movies -- Total runtime

// 1 movie1 8 50min

// 2 movie1 8 50min

// 3 movie1 8.3 50min

// 4 movie1 8.5 50min



// 8          2     100
// 8.3        1     50
// 8.5        1     50

// CRUD

// READ

// CREATE

// UPDATE

// DELETE
