package com.delivrey.entity;

import com.delivrey.entity.DeliveryStatus;
import jakarta.persistence.*;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private double latitude;
    private double longitude;
    private double weight;
    private double volume;
    private String timeWindow;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status = DeliveryStatus.PENDING;

    public Delivery() {}

    // Getters, Setters
}
