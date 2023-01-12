package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.UserRegistrationDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
     public String register(Model model) {
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        model.addAttribute("userRegistrationDTO", userRegistrationDTO);

        return "register";
     }

    @PostMapping("/register")
    public String doRegister(UserRegistrationDTO userRegistrationDTO) {
        System.out.println(userRegistrationDTO.toString());

        return "redirect:/register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }





}
