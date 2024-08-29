package ci.digitalacademy.monetab.services.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id_user;

    private String pseudo;

    private String password;

    private Instant creationDate;

}
