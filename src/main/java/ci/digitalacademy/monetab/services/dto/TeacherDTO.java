package ci.digitalacademy.monetab.services.dto;


import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TeacherDTO extends PersonDTO{

    private Boolean vacant;

    private String matiereEnseigne;

}
