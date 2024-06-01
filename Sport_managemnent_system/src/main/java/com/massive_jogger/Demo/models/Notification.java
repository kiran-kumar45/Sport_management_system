package com.massive_jogger.Demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Notification {
    @GeneratedValue
    @Id
    private Long id;
    @NotEmpty
    @NotBlank
    private String subject;
    @NotEmpty
    @NotBlank
    private String content;
    private LocalDateTime createdAt;
}
