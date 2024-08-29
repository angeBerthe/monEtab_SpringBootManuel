package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) //lié d'autre table au table enfant
//@DiscriminatorColumn(name = "person_type")
@Entity
@Table(name = "person")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id_person;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "ville", nullable = false)
    private String ville;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateDeNaissance", nullable = false)
    private Date dateDeNaissance;

}
