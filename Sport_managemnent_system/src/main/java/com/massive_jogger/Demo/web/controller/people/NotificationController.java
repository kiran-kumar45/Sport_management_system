package com.massive_jogger.Demo.web.controller.people;

import com.massive_jogger.Demo.data.NotificationRepository;
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
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationRepository notificationRepository;

    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping
    public String showNotifications(Model model) {
        List<Notification> notifications = (List<Notification>) notificationRepository.findAll();
        model.addAttribute("notifications", notifications); // Correct attribute name
        model.addAttribute("notification", new Notification()); // Add this line
        return "notification"; // Use lowercase template name
    }

    @PostMapping
    public String Notify(@Valid Notification notification, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "notification"; // Return to the form with error messages
        }
        LocalDateTime CurrentDateTimeProvider=LocalDateTime.now();
        notification.setCreatedAt(CurrentDateTimeProvider);
        notificationRepository.save(notification); // Save the notification
        return "redirect:/notification"; // Redirect to the notification list
    }

    @PostMapping(params="delete=true")
    public String deleteNotification(@RequestParam Optional<List<Long>> selected){
        if(selected.isPresent()){
           notificationRepository.deleteAllById(selected.get());
            return "redirect:/notification";
        }
        return "notification";
    }

    // Add methods for sending and deleting notifications
}
