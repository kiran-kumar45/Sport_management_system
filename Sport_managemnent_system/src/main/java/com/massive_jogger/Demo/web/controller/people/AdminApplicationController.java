package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.ApplicationRepository;
import com.massive_jogger.Demo.data.CurrentApplicationRepository;
import com.massive_jogger.Demo.models.Application;
import com.massive_jogger.Demo.models.CurrentApplication;
import com.massive_jogger.Demo.models.Notification;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/adminApplication")
public class AdminApplicationController {
    private final CurrentApplicationRepository applicationRepository;
    private final List<CurrentApplication> notifications;
    public AdminApplicationController(CurrentApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
        notifications = (List<CurrentApplication>) applicationRepository.findAll();
    }


    @GetMapping
    public String showNotifications(Model model) {
        model.addAttribute("application", new CurrentApplication()); // Add this line
        return "adminApplication"; // Use lowercase template name
    }

    @PostMapping
    public String Notify(@Valid CurrentApplication applyStatus, Errors errors, Model model) {
        System.out.println(applyStatus);
        applicationRepository.deleteAll(notifications);
        applicationRepository.save(applyStatus);
        return "redirect:/notification";
    }
}
