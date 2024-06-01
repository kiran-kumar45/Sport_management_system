package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.ReportRepository;
import com.massive_jogger.Demo.models.Notification;
import com.massive_jogger.Demo.models.Report;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

@Controller
@RequestMapping("/achievements")
public class AchievementsController {
    private final ReportRepository reportRepository;

    public AchievementsController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
    @GetMapping
    public String getPeople(Model model) {
        List<Report> notifications = (List<Report>) reportRepository.findAll();
        model.addAttribute("achievements",notifications);
        return "achievements";
    }
}
