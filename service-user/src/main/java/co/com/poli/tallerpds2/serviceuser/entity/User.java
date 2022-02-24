package co.com.poli.tallerpds2.serviceuser.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "El nombre del usuario no puede ser vacio")
    private String name;

    @Column(name = "lastname", nullable = false)
    @NotEmpty(message = "El apellido del usuario no puede ser vacio")
    private String lastname;


}
