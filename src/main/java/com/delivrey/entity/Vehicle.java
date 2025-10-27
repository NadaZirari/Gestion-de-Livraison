package com.delivrey.entity;

import com.delivrey.entity.VehicleType;
import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private double maxWeight;
    private double maxVolume;
    private int maxDeliveries;

    public Vehicle() {}

    // Getters, Setters
}
