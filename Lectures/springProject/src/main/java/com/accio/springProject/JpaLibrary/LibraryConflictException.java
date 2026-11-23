package com.accio.springProject.JpaLibrary;

public class LibraryConflictException extends RuntimeException {
    public LibraryConflictException(String message) {
        super(message);
    }
}
