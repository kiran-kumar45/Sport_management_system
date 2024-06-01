package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.CurrentApplicationRepository;
import com.massive_jogger.Demo.data.PersonRepository;
import com.massive_jogger.Demo.models.CurrentApplication;
import com.massive_jogger.Demo.models.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final PersonRepository personRepository;
    private final CurrentApplicationRepository repository;

    public RegistrationController(PersonRepository personRepository, CurrentApplicationRepository repository) {
        this.personRepository = personRepository;
        this.repository = repository;
    }


    @GetMapping
    @ModelAttribute("/person")
    public String showRegistrationForm(Model model) {
        List<CurrentApplication> status= (List<CurrentApplication>) repository.findAll();
        CurrentApplication stat=status.get(0);
        return "registration";
    }

    @ModelAttribute
    public Person showPerson() {
        return new Person();
    }

    @PostMapping
    public String processRegistrationForm(@Valid Person person, Errors error) {
        if (!error.hasErrors()) {
            System.out.println(person);
            if (Objects.equals(person.getPassword(), person.getConfirmPassword())) {
                List<Person> existedUser = (List<Person>) personRepository.findAll();
                System.out.println("checking...!");
                for (Person check : existedUser) {
                    System.out.println("working");
                    if (Objects.equals(check.getUsn().toLowerCase(), person.getUsn().toLowerCase())) {
                        System.out.println(true);
                        return "redirect:/registration?error";
                    }
                }
                    this.personRepository.save(person);
                    System.out.println("Person save to database sucessfully");
                    return "redirect:/login"; // Redirect back to the registration form
            }
        }
        return "/registration"; // Redirect back to the registration form
    }
}



