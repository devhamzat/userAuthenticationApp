package org.devhamzat.userauthentication.controller;

import jakarta.validation.Valid;
import org.devhamzat.userauthentication.dto.UserDto;
import org.devhamzat.userauthentication.entity.User;
import org.devhamzat.userauthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, Model model) {
        Optional<User> existingUser = userService.findUserByEmailOrUserName(userDto.getEmail(), userDto.getUserName());
        if (existingUser.isPresent() || !existingUser.isEmpty()) {
            model.addAttribute("Userexist", existingUser);
            return "register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

}
