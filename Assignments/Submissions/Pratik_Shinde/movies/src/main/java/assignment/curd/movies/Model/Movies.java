package assignment.curd.movies.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.Year;
import java.util.Date;
import java.util.UUID;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movies {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID uuid;

    @Column(name = "movie-name")
    @NotBlank(message = "cant be null")
    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Year date;
}
