package ci.digitalacademy.monetab.services.dto;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id_person;

    private String firstName;

    private String lastName;

    private String email;

    private String genre;

    private String ville;

    private String telephone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateDeNaissance", nullable = false)
    private Date dateDeNaissance;

}
