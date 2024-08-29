package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.dto.StudentDTO;

public final class StudentMapper {

    private StudentMapper(){}

    public static StudentDTO fromEntity(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId_person(student.getId_person());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setTelephone(student.getTelephone());
        studentDTO.setVille(student.getVille());
        studentDTO.setGenre(student.getGenre());
        studentDTO.setDateDeNaissance(student.getDateDeNaissance());
        studentDTO.setMatricule(student.getMatricule());
        studentDTO.setClasse(student.getClasse());
        return studentDTO;
    }

    public static Student toEntity(StudentDTO studentDTO){
        Student student = new Student();
        student.setId_person(studentDTO.getId_person());
        student.setLastName(studentDTO.getLastName());
        student.setFirstName(studentDTO.getFirstName());
        student.setEmail(studentDTO.getEmail());
        student.setTelephone(studentDTO.getTelephone());
        student.setVille(studentDTO.getVille());
        student.setGenre(studentDTO.getGenre());
        student.setDateDeNaissance(studentDTO.getDateDeNaissance());
        student.setMatricule(studentDTO.getMatricule());
        student.setClasse(studentDTO.getClasse());
        return student;
    }

}
