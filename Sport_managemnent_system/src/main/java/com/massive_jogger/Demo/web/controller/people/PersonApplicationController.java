package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.ApplicationRepository;
import com.massive_jogger.Demo.data.CurrentApplicationRepository;
import com.massive_jogger.Demo.models.Application;
import com.massive_jogger.Demo.models.CurrentApplication;
import com.massive_jogger.Demo.models.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

import static com.massive_jogger.Demo.web.controller.people.LoginController.person;

@Controller
@RequestMapping("/applicationcontroller")
public class PersonApplicationController {
    private final ApplicationRepository ApplicationController;
    private final CurrentApplicationRepository currentStatus;
    Person check=LoginController.person;
    List<CurrentApplication> applications;
    CurrentApplication current;
    public PersonApplicationController(ApplicationRepository applicationController, CurrentApplicationRepository currentStatus) {
        ApplicationController = applicationController;
        this.currentStatus = currentStatus;
        applications= (List<CurrentApplication>) currentStatus.findAll();
        current= ((List<CurrentApplication>) currentStatus.findAll()).get(0);
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("person",person);
        model.addAttribute("application",new Application());
        return "applicationcontroller";
    }

    @PostMapping
    public String processApplicationForm(@Valid Application applicaion, Errors error) {
        String type = current.getType();
            System.out.println(applicaion);
            System.out.println(person);
            applicaion.setUsn(person.getUsn());
            applicaion.setFirstName(person.getFirstName());
            applicaion.setLastName(person.getLastName());
            applicaion.setType(current.getType());
            System.out.println(applicaion);
            ApplicationController.save(applicaion);
            return "redirect:/login";
    }
}

