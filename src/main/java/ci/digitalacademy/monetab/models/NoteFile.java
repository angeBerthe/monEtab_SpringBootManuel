package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "noteFile")
public class NoteFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_noteFile;

    @Column(nullable = false, name = "Note")
    private String Note;

    @Column(nullable = false, name = "annee")
    private String annee;

}
