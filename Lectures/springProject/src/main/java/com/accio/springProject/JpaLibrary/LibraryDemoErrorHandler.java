package com.accio.springProject.JpaLibrary;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = LibraryDemoController.class)
public class LibraryDemoErrorHandler {
    public record ApiError(String message) {}

    @ExceptionHandler(LibraryNotFoundException.class)
    public ResponseEntity<ApiError> missing(LibraryNotFoundException ex) {
        return ResponseEntity.status(404).body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler(LibraryConflictException.class)
    public ResponseEntity<ApiError> conflict(LibraryConflictException ex) {
        return ResponseEntity.status(409).body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> invalidBody(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest()
                .body(new ApiError("Check the required fields and their limits"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> invalid(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> duplicate(DataIntegrityViolationException ex) {
        return ResponseEntity.status(409)
                .body(new ApiError("A unique value or relationship is already in use"));
    }
}
