package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.ReportRepository;
import com.massive_jogger.Demo.models.Notification;
import com.massive_jogger.Demo.models.Report;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/report")
public class ReportController {
    private final ReportRepository repository;

    public ReportController(ReportRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public String showNotifications(Model model) {
        List<Report> notifications = (List<Report>) repository.findAll();
        model.addAttribute("values", notifications); // Correct attribute name
        model.addAttribute("report", new Report()); // Add this line
        return "report"; // Use lowercase template name
    }

    @PostMapping
    public String Notify(@Valid Report report, Errors errors, Model model) {
        List<Report> list = (List<Report>) repository.findAll();
        boolean action=false;
        for (int i = 0; i < list.size(); i++) {
            Report ports = list.get(i);
            if(Objects.equals(ports.getYearPlayed(), report.getYearPlayed()) && Objects.equals(ports.getType(), report.getType())){
                action=true;
            }
        }
        if (errors.hasErrors()||action) {
            return "report"; // Return to the form with error messages
        }
        else {
            repository.save(report); // Save the notification
            return "redirect:/report"; // Redirect to the notification list
        }
    }

    @PostMapping(params="delete=true")
    public String deleteNotification(@RequestParam Optional<List<Long>> selected){
        if(selected.isPresent()){
            repository.deleteAllById(selected.get());
            return "redirect:/report";
        }
        else return "/report";
    }
}
