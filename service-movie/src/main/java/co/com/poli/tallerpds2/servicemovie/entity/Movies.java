package co.com.poli.tallerpds2.servicemovie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotEmpty(message = "La pelicula debe tener un titulo")
    private String title;

    @Column(name = "director", nullable = false)
    @NotEmpty(message = "La pelicula un director")
    private String director;

    @Column(name = "raiting")
    @Min(1)
    @Max(5)
    private String raiting;
}
