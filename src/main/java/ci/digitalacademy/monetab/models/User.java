package ci.digitalacademy.monetab.models;



import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(nullable = false,name = "pseudo",unique = true)
    private String pseudo;

    @Column(nullable = false,name = "password")
    private String password;

    @Column(nullable = false,name = "creation_date")
    private Instant creationDate;

}
