package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.NoteFile;
import ci.digitalacademy.monetab.repositories.NoteFileRepository;
import ci.digitalacademy.monetab.services.NoteFileService;
import ci.digitalacademy.monetab.services.dto.NoteFileDTO;
import ci.digitalacademy.monetab.services.mapper.NoteFileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoteFileServiceImpl implements NoteFileService {

    private final NoteFileRepository  noteFileRepository;


    @Override
    public NoteFileDTO save(NoteFileDTO noteFileDTO) {
        log.debug("Request to save: {}", noteFileDTO);
        NoteFile noteFile = NoteFileMapper.toEntity(noteFileDTO);
        noteFile = noteFileRepository.save(noteFile);
        return NoteFileMapper.fromEntity(noteFile);
    }

    @Override
    public NoteFileDTO update(NoteFileDTO noteFileDTO) {
        log.debug("Request to update:{}", noteFileDTO);
        return findOne(noteFileDTO.getId_noteFile()).map(existingNoteFile ->{
            existingNoteFile.setNote(noteFileDTO.getNote());
            existingNoteFile.setAnnee(noteFileDTO.getAnnee());
            return save(noteFileDTO);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<NoteFileDTO> findOne(Long id_noteFile) {
        log.debug("Resquest to get id: {}", id_noteFile);
        return noteFileRepository.findById(id_noteFile).map(noteFile -> {
            return NoteFileMapper.fromEntity(noteFile);
        });
    }

    @Override
    public List<NoteFileDTO> findAll() {
        return noteFileRepository.findAll().stream().map(noteFile -> {
            return NoteFileMapper.fromEntity(noteFile);
        }).toList();
    }

    @Override
    public void delete(Long id_noteFile) {
        noteFileRepository.deleteById(id_noteFile);
    }
}
