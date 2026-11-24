package com.accio.springProject.JpaLibrary;

import com.accio.springProject.JpaLibrary.LibraryViews.*;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jpa/library")
public class LibraryDemoController {

    private final LibraryDemoService demoService;

    public LibraryDemoController(LibraryDemoService service){
        this.demoService = service;
    }

    @GetMapping("/student/{id}")
    public LibraryViews.StudentView studentDetails(@PathVariable("id") Long id){
        return this.demoService.student(id);
    }

    @GetMapping("/books/{id}")
    public BookView book(@PathVariable("id") Long id){
        return demoService.book(id);
    }

    @PostMapping("/books/{bookId}/authors/{authorId}")
    public void attachAuthor(@PathVariable("bookId") Long bookId, @PathVariable("authorId") Long authorId){
        demoService.attachAuthor(bookId, authorId);
    }

    @GetMapping("/shelves/{roomCode}/{position}")
    public ShelfView shelf(@PathVariable("roomCode") String roomCode, @PathVariable("position") int position){
        return demoService.shelf(roomCode, position);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentView> createStudent(
            @Valid @RequestBody LibraryInput.StudentInput input){
        return ResponseEntity.ok(demoService.createStudent(input));
    }
}

// Entity --> Columns [Table]
// @Id --> Primary Key
// Object --> Column1 +  column2 --> primary key
// Entity
