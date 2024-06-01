package com.massive_jogger.Demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    public Long id;
    private String type="Student";
    @NotEmpty(message = "First Name is required")
    @NotBlank(message = "Name can't be blank")
    private String firstName;
    @NotEmpty(message = "Last Name is required")
    @NotBlank(message = "Name can't be blank")
    private String lastName;
    @NotEmpty(message = "College usn must be required")
    private String usn;
    @NotEmpty(message = "Branch is required")
    private String branch;
    @Past(message = "Date must be of past ")
    private LocalDate dob;
    @Email(message= "required Personal Email")
    private String email;
    private String confirmPassword;
    private String password;
    private char gender='M';
}
