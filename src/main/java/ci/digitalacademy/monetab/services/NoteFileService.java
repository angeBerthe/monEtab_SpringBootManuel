package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.NoteFile;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.dto.NoteFileDTO;

import java.util.List;
import java.util.Optional;

public interface NoteFileService {

    NoteFileDTO save(NoteFileDTO noteFileDTO);

    NoteFileDTO update(NoteFileDTO noteFileDTO);

    Optional<NoteFileDTO> findOne(Long id_noteFile);

    List<NoteFileDTO> findAll();

    void delete(Long id_noteFile);
}
