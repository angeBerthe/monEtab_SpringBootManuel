package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save:{}",studentDTO);
        Student student = StudentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return StudentMapper.fromEntity(student);

    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        log.debug("Request to update:{}", studentDTO);
        return findOne(studentDTO.getId_person()).map(existiengStudent->{
            existiengStudent.setLastName(studentDTO.getLastName());
            existiengStudent.setFirstName(studentDTO.getFirstName());
            existiengStudent.setDateDeNaissance(studentDTO.getDateDeNaissance());
            existiengStudent.setVille(studentDTO.getVille());
            existiengStudent.setTelephone(studentDTO.getTelephone());
            existiengStudent.setClasse(studentDTO.getClasse());
            existiengStudent.setEmail(studentDTO.getEmail());
            existiengStudent.setGenre(studentDTO.getGenre());
            existiengStudent.setMatricule(studentDTO.getMatricule());
            return save(studentDTO);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<StudentDTO> findOne(Long id_person) {
        log.debug("Resquest to get id: {}", id_person);
        return studentRepository.findById(id_person).map(student -> {
            return StudentMapper.fromEntity(student);
        });
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(student -> {
            return StudentMapper.fromEntity(student);
        }).toList();
    }

    @Override
    public void delete(Long id_person) {
        studentRepository.deleteById(id_person);
    }
}
