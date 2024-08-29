package ci.digitalacademy.monetab.services.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NoteFileDTO {

    private Long id_noteFile;

    private String Note;

    private String annee;
}
