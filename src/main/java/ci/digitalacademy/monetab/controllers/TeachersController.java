package ci.digitalacademy.monetab.controllers;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/teachers")
public class TeachersController {
    private final TeacherService teacherService;


    @GetMapping("/add")
    public String showAddTeacherPage(Model model){
        model.addAttribute("teacher", new TeacherDTO());
        return "teachers/forms";
    }

    @PostMapping
    public String saveTeacher(TeacherDTO teacherDTO){
        log.debug("Request to save teacher");
        teacherService.save(teacherDTO);
        return "redirect:/teachers";
    }

    @GetMapping
    public String showTeacherPage(Model model){
        List<TeacherDTO> teacherDTOS = teacherService.findAll();
        model.addAttribute("teachers",teacherDTOS);
        return "teachers/list";
    }

    @GetMapping("/{id_person}")
    public String showUpdateTeacherForms(@PathVariable Long id_person, Model model){
        log.debug("Request to show update student forms");
        Optional<TeacherDTO> teacherDTO = teacherService.findOne(id_person);
        if (teacherDTO.isPresent()){
            model.addAttribute("teacher", teacherDTO.get());
            return "teachers/forms";
        }else {
            return "redirect:/teachers";
        }
    }

    @PostMapping("/{id_person}")
    public String deleteTeacher(@PathVariable Long id_person) {
        teacherService.delete(id_person);
        return "redirect:/teachers";
    }
}
