package com.accio.springProject.JpaLibrary;

import com.accio.springProject.JpaLibrary.LibraryViews.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional()
public class LibraryDemoService {

    private final LibraryStudentRepository studentRepository;
    private final LibraryAuthorRepository authors;
    private final LibraryBookRepository books;
    private final ShelfPositionRepository shelves;

    public LibraryDemoService(LibraryStudentRepository studentRepository,
                              LibraryAuthorRepository authors,
                              LibraryBookRepository books,
                              ShelfPositionRepository shelves){
        this.studentRepository = studentRepository;
        this.authors = authors;
        this.books = books;
        this.shelves = shelves;
    }

    public BookView book(Long id){
        LibraryBook book = books.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Book was not found!"));

        List<String> names = new ArrayList<>();
        for(LibraryAuthor author : book.getAuthors()){
            names.add(author.getName());
        }

        return new BookView(book.getId(), book.getTitle(), names);
    }

    @Transactional
    public void attachAuthor(Long bookId, Long authorId){
        LibraryBook book = books.findById(bookId)
                .orElseThrow(() -> new LibraryNotFoundException("Book was not found!"));

        LibraryAuthor author = authors.findById(authorId)
                .orElseThrow(() -> new LibraryNotFoundException("Author was not found!"));

        book.getAuthors().add(author);
    }

    public LibraryViews.StudentView student(Long id){
        LibraryStudent student  = studentRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Student not found"));

        List<LibraryViews.LoanView> result = new ArrayList<>();

        for(LibraryLoan loan : student.getLoans()){
            result.add(new LibraryViews.LoanView(loan.getId(), loan.getLibraryStudent().getId(),
                    loan.getLibraryStudent().getName(), loan.getLibrarybook().getTitle()));
        }

        return new LibraryViews.StudentView(student.getId(), student.getName(), student.getCard().getCode(), result);
    }

    public ShelfView shelf(String roomCode, int position){
        ShelfPositionId id = new ShelfPositionId(roomCode, position);

        ShelfPosition shelf = shelves.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Shelf position not found!"));

        return new ShelfView(shelf.getId().getRoomCode(),
                shelf.getId().getPosition(), shelf.getBook().getTitle());
    }

    public StudentView createStudent(LibraryInput.StudentInput input){
        LibraryCard card = new LibraryCard(input.cardCode());

        LibraryStudent newStudent = studentRepository.save(new LibraryStudent(input.name(), card));

        return student(newStudent.getId());
    }
}
// localhost:8081/library/index.html