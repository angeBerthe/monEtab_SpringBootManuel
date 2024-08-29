package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;

public final class TeacherMapper {

    private TeacherMapper(){}

    public static TeacherDTO fromEntity(Teacher teacher){
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId_person(teacher.getId_person());
        teacherDTO.setLastName(teacher.getLastName());
        teacherDTO.setFirstName(teacher.getFirstName());
        teacherDTO.setEmail(teacher.getEmail());
        teacherDTO.setTelephone(teacher.getTelephone());
        teacherDTO.setGenre(teacher.getGenre());
        teacher.setDateDeNaissance(teacher.getDateDeNaissance());
        teacherDTO.setMatiereEnseigne(teacher.getMatiereEnseigne());
        teacherDTO.setVacant(teacher.getVacant());
        return teacherDTO;
    }

    public static Teacher toEntity(TeacherDTO teacherDTO){
        Teacher teacher = new Teacher();
        teacher.setId_person(teacherDTO.getId_person());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setTelephone(teacherDTO.getTelephone());
        teacher.setVille(teacherDTO.getVille());
        teacher.setGenre(teacherDTO.getGenre());
        teacher.setDateDeNaissance(teacherDTO.getDateDeNaissance());
        teacher.setMatiereEnseigne(teacherDTO.getMatiereEnseigne());
        teacher.setVacant(teacherDTO.getVacant());
        return teacher;
    }

}
