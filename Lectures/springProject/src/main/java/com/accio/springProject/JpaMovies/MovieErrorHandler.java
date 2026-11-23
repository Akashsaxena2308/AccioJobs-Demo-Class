package com.accio.springProject.JpaMovies;


import com.accio.springProject.Doctors.Model.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = MoviesController.class)
public class MovieErrorHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ApiError> missing(MovieNotFoundException ex){
        return ResponseEntity.status(404).body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> invalid(MethodArgumentNotValidException ex){
        return ResponseEntity.status(400).body(new ApiError(ex.getMessage()));
    }
}
