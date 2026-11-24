package com.accio.springProject.JpaLibrary;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LibraryInput {
    public record StudentInput(
            @NotBlank @Size(max = 100) String name,
            @NotBlank @Size(max = 100) String cardCode
    ){

    }
}
