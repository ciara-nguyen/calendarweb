package com.calendar.calendarweb.controllers;

import com.calendar.calendarweb.dto.UserDto;
import com.calendar.calendarweb.entities.CustomUserDetail;
import com.calendar.calendarweb.entities.User;
import com.calendar.calendarweb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalendarController {
    @Autowired
    private UserService userService;

    @GetMapping({"/","/index"})
    public String viewHome() {
        //model.addAttribute("failmessage", "Enter email and password to log in");
        //model.addAttribute("acc", new Account());
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user= new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        User existingUser= userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email",null, "There is already an account registered with the same email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/signin")
    public String login() {
        return "/signin";
    }




    /*@GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("account", new Account());
        return "signup";
    }

    @PostMapping("/process_register")
    public String createAccount(@ModelAttribute("account") Account account) {
        accountService.add(account);
        return "register_success";
    }*/

    @GetMapping("/maincalendar")
    public String displayCalendar(@AuthenticationPrincipal CustomUserDetail userDetail, Model model) {
        model.addAttribute("displayname", userDetail.getUser().getDisplayName());
        return "maincalendar";
    }
}
