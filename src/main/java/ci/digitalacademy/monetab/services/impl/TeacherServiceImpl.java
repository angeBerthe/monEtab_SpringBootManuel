package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repositories.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        log.debug("Request to save: {}", teacherDTO );
        Teacher teacher = TeacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return TeacherMapper.fromEntity(teacher);
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {
        log.debug("Request to update: {}", teacherDTO);
        return findOne(teacherDTO.getId_person()).map(existingTeacher ->{
            existingTeacher.setLastName(teacherDTO.getLastName());
            existingTeacher.setFirstName(teacherDTO.getFirstName());
            existingTeacher.setDateDeNaissance(teacherDTO.getDateDeNaissance());
            existingTeacher.setVille(teacherDTO.getVille());
            existingTeacher.setTelephone(teacherDTO.getTelephone());
            existingTeacher.setMatiereEnseigne(teacherDTO.getMatiereEnseigne());
            existingTeacher.setEmail(teacherDTO.getEmail());
            existingTeacher.setGenre(teacherDTO.getGenre());
            existingTeacher.setVacant(teacherDTO.getVacant());
            return save(teacherDTO);
        }).orElseThrow(() ->new IllegalArgumentException());

    }

    @Override
    public Optional<TeacherDTO> findOne(Long id_person) {
        log.debug("Resquest to get id: {}", id_person);
        return teacherRepository.findById(id_person).map(teacher -> {
            return TeacherMapper.fromEntity(teacher);
        });
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(teacher -> {
            return TeacherMapper.fromEntity(teacher);
        }).toList();
    }

    @Override
    public void delete(Long id_teacher) {
        teacherRepository.deleteById(id_teacher);
    }
}
