package org.devhamzat.userauthentication.controller;

import jakarta.validation.Valid;
import org.devhamzat.userauthentication.dto.UserDto;
import org.devhamzat.userauthentication.entity.User;
import org.devhamzat.userauthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;


    @GetMapping("/index")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        Optional<User> existingUser = Optional.of(new User(userDto.getEmail(), userDto.getFirstName(), userDto.getLastName(), passwordEncoder.encode(userDto.getPassword())));
        userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.get().getEmail() != null && !existingUser.get().getEmail().isEmpty()) {
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

}
