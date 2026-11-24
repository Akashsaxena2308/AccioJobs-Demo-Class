package com.accio.springProject.JpaMovies;

import jakarta.validation.constraints.*;

public record MovieInput (
    @NotBlank @Size(max = 100) String name,
    @NotNull @Min(1) @Max(600) Integer time,
    @NotNull @DecimalMin("0.0") @DecimalMax("10.0") Double rating
){

};
