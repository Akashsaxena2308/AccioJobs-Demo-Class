package com.accio.springProject.JpaLibrary;

import java.util.List;

public class LibraryViews {

    public record StudentView(Long id,
                              String name,
                              String cardCode,
                              List<LoanView> loans){

    }

    public record LoanView(Long id,
                           Long studentId,
                           String student,
                           String book){

    }

}
