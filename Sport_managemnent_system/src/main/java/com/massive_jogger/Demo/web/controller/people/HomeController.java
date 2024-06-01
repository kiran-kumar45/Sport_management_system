package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.NotificationRepository;
import com.massive_jogger.Demo.models.Notification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class HomeController {
    private final NotificationRepository notificationRepository;
    public HomeController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping
    public String getPeople(Model model) {
        List<Notification> notifications= (List<Notification>) notificationRepository.findAll();
        model.addAttribute("index",notifications);
        return "index";
    }
}
