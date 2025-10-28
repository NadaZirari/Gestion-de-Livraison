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

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getTourDate() {
		return tourDate;
	}

	public void setTourDate(LocalDate tourDate) {
		this.tourDate = tourDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public String getAlgorithmUsed() {
		return algorithmUsed;
	}

	public void setAlgorithmUsed(String algorithmUsed) {
		this.algorithmUsed = algorithmUsed;
	}

	@ManyToOne
    private Warehouse warehouse;

    @ManyToMany
    private List<Delivery> deliveries;

    private String algorithmUsed;

    public Tour() {}

    // Getters, Setters
}
