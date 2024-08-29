package ci.digitalacademy.monetab.controllers;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/students")
public class StudentsController {

    private final StudentService studentService;

    @GetMapping("/add")
    public String showAddStudentPage(Model model){
        model.addAttribute("student", new StudentDTO());
        return "students/forms";
    }

    @PostMapping
    public String saveStudent( StudentDTO studentDTO){
        log.debug("Request to save student");
        studentService.save(studentDTO);
        return "redirect:/students";
    }

    @GetMapping
    public String showStudentPage(Model model){
        log.debug("Request to show student");
        List<StudentDTO> studentDTOS = studentService.findAll();
        model.addAttribute("students", studentDTOS);
        return "students/list";
    }

    @GetMapping("/{id_person}")
    public String showUpdateStudentForms(@PathVariable Long id_person, Model model){
        log.debug("Request to show update student forms");
        Optional<StudentDTO> studentDTO = studentService.findOne(id_person);
        if (studentDTO.isPresent()){
            model.addAttribute("student", studentDTO.get());
            return "students/forms";
        }else {
            return "redirect:/students";
        }
    }

    @PostMapping("/{id_person}")
    public String deleteStudent(@PathVariable Long id_person) {
        studentService.delete(id_person);
        return "redirect:/students";
    }
}
