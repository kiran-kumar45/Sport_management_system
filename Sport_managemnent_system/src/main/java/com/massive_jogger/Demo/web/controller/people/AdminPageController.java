package com.massive_jogger.Demo.web.controller.people;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPageController {
    @GetMapping
    @ModelAttribute("/admin")
    public String getPeople(Model model) {
        return "notification";
    }
}
