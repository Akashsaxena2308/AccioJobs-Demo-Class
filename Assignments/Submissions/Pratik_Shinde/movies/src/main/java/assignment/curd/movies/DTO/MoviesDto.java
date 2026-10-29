package assignment.curd.movies.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.text.Format;
import java.time.Year;
import java.util.Date;

@Data
@Setter
@Getter
public class MoviesDto {
    @NotBlank(message = "Movies title cannot be blank")
    @NotEmpty(message = "cant be empty")
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Year date;
}
