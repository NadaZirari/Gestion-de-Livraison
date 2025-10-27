package com.delivrey.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate tourDate;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToMany
    private List<Delivery> deliveries;

    private String algorithmUsed;

    public Tour() {}

    // Getters, Setters
}
