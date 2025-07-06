package com.examplejride.jride.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupLocation;
    private String dropOffLocation;
    private String rideType;
    private String status;

    @ManyToOne
    private User passenger;

    @ManyToOne
    private Driver driver;
}
