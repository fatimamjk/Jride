package com.examplejride.jride.model;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone is required")
    private String phone;

    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "License number is required")
    private String licenseNumber;

    private String vehicleType; // e.g., Car, Bike
    private String vehicleNumber; // e.g., ABC-123

    private String availabilityStatus; // e.g., "available", "busy"
}
