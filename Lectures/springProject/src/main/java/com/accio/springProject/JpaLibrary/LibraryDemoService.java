package com.accio.springProject.JpaLibrary;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional()
public class LibraryDemoService {

    private final LibraryStudentRepository studentRepository;

    public LibraryDemoService(LibraryStudentRepository studentRepository){
        this.studentRepository = studentRepository;

    }

    public LibraryViews.StudentView student(Long id){
        LibraryStudent student  = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        List<LibraryViews.LoanView> result = new ArrayList<>();

        for(LibraryLoan loan : student.getLoans()){
            result.add(new LibraryViews.LoanView(loan.getId(), loan.getLibraryStudent().getId(),
                    loan.getLibraryStudent().getName(), loan.getLibrarybook().getTitle()));
        }

        return new LibraryViews.StudentView(student.getId(), student.getName(), student.getCard().getCode(), result);
    }
}
