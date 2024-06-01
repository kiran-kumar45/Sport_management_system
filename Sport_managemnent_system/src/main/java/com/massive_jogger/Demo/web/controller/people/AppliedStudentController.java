package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.ApplicationRepository;
import com.massive_jogger.Demo.models.Application;
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
@RequestMapping("/applied")
public class AppliedStudentController{
    private final ApplicationRepository application;

    public AppliedStudentController(ApplicationRepository application) {
        this.application = application;
    }


    @GetMapping
    public String showNotifications(Model model) {
        List<Application> appliedStudent = (List<Application>) application.findAll();
        model.addAttribute("list", appliedStudent); // Correct attribute name
        model.addAttribute("list", new Application()); // Add this line
        return "/applied"; // Use lowercase template name
    }

    @PostMapping(params="delete=true")
    public String deleteNotification(@RequestParam Optional<List<Long>> selected){
        if(selected.isPresent()){
            application.deleteAllById(selected.get());
            return "redirect:/applied";
        }
        return "/applied";
    }
}
