package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.NoteFile;
import ci.digitalacademy.monetab.services.dto.NoteFileDTO;

public final class NoteFileMapper {

    private NoteFileMapper(){}

    public static NoteFileDTO fromEntity(NoteFile noteFile){
        NoteFileDTO noteFileDTO = NoteFileDTO.builder()
                .id_noteFile(noteFile.getId_noteFile())
                .Note(noteFile.getNote())
                .annee(noteFile.getAnnee())
                .build();
        return noteFileDTO;
    }

    public static NoteFile toEntity(NoteFileDTO noteFileDTO){
        NoteFile noteFile = NoteFile.builder()
                .id_noteFile(noteFileDTO.getId_noteFile())
                .Note(noteFileDTO.getNote())
                .annee(noteFileDTO.getAnnee())
                .build();
        return noteFile;

    }
}
