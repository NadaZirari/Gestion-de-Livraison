package com.delivrey.entity;

import jakarta.persistence.*;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private double latitude;
    private double longitude;
    private String openingHours = "06:00-22:00";

    public Warehouse() {}

    // Getters, Setters
}
