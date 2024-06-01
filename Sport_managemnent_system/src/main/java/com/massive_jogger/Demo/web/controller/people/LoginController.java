package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.NotificationRepository;
import com.massive_jogger.Demo.data.PersonRepository;
import com.massive_jogger.Demo.models.Person;
import com.massive_jogger.Demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {
    public static Person person;
    private final PersonRepository personRepository;
    private final NotificationRepository notificationRepository;

    public LoginController(PersonRepository personRepository, NotificationRepository notificationRepository) {
        this.personRepository = personRepository;
        this.notificationRepository = notificationRepository;
    }

    @GetMapping
    @ModelAttribute("/user")
    public String getPerson() {
        return "redirect:user";
    }

    @ModelAttribute
    public User showUser() {
        return new User();
    }



    @PostMapping
    public String getPerson(User user) {
        System.out.println(user);
        List<Person> existedUsers = (List<Person>) personRepository.findAll();
        if (Objects.equals(user.getUserName(), "Admin") && Objects.equals(user.getPassword(), "Bitm@123") && Objects.equals(user.getType(), "Admin")) {
            return "redirect:/notification";
        } else if (Objects.equals(user.getType(), "Student")) {
            System.out.println("checking...!");
            for (Person check : existedUsers) {
                System.out.println("working");
                if (Objects.equals(check.getUsn().toLowerCase(), user.getUserName().toLowerCase()) && Objects.equals(check.getPassword(), user.getPassword())) {
                    System.out.println(true);
                    person=check;
                    return "redirect:/profile";
                }
            }
        }
        return "redirect:/login?error";
    }
}
