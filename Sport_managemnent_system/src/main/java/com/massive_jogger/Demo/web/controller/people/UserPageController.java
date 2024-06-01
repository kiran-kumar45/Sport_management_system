package com.massive_jogger.Demo.web.controller.people;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserPageController {
    @GetMapping
    @ModelAttribute("/user")
    public String showRegistrationForm(Model model) {
        return "user";
    }

}
