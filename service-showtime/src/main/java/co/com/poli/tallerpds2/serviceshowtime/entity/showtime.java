package co.com.poli.tallerpds2.serviceshowtime.entity;

import co.com.poli.tallerpds2.serviceshowtime.model.Movies;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "invoice_items")
public class showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "moviesId")
    private Long moviesId;

    @Transient
    private Movies movies;


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
