package ci.digitalacademy.monetab.controllers;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping
public class AuthController {

    private final UserService userService;

    @GetMapping
    public String showLogin(Model model){
        model.addAttribute("user", new UserDTO());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("pseudo") String pseudo,
                        @RequestParam("password") String password,
                        Model model) {
        log.debug("Attempting to log in with pseudo: {}", pseudo);

        Optional<UserDTO> userDTO = userService.findByPseudoAndPassword(pseudo, password);

        if (userDTO.isPresent()) {
            // Connexion réussie, redirection vers la page d'accueil
            return "redirect:/home";
        } else {
            // Connexion échouée, renvoi au formulaire de connexion avec un message d'erreur
            model.addAttribute("error", "Pseudo ou mot de passe incorrect.");
            return "auth/login";
        }
    }
}

