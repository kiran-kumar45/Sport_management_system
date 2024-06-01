package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.PersonRepository;
import com.massive_jogger.Demo.models.Notification;
import com.massive_jogger.Demo.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final PersonRepository person;

    public ProfileController(PersonRepository person) {
        this.person = person;
    }


    @GetMapping
    public String getPeople(Model model) {
        Person check=LoginController.person;
        model.addAttribute("person",check);
        return "/profile";
    }
}
