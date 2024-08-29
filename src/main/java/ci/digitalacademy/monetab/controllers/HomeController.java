package ci.digitalacademy.monetab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class HomeController {

    @GetMapping("/home")
    public String showHomePage(){
        return "Home/dashboad";
    }
}
