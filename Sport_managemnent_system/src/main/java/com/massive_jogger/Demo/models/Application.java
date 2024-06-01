package com.massive_jogger.Demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Application {
    @Id
    @GeneratedValue
    private Long id;
    private String usn;
    private String firstName;
    private String lastName;

    @NotBlank(message = "Father's Name is required")
    private String father;

    @NotBlank(message = "Mother's Name is required")
    private String mother;

    @Range(min = 0, max = 300, message = "Height must be between 0 and 300 cm")
    private Long height;

    @Range(min = 0, max = 300, message = "Weight must be between 0 and 300 kg")
    private Long weight;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone Number must be a 10-digit number")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Black Mark is required")
    private String blackMark;

    @NotBlank(message = "Blood Group is required")
    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid Blood Group format. Please use A/B/AB/O followed by + or -.")
    private String bloodgroup;

    @NotBlank(message = "Type is required")
    private String type;
}
