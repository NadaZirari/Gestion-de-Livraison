package com.delivrey.dto;

public class WarehouseDTO {
    private Long id;
    private String address;
    private double latitude;
    private double longitude;
    private String openingHours;

    // Constructeur
    public WarehouseDTO(Long id, String address, double latitude, double longitude, String openingHours) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.openingHours = openingHours;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public String getOpeningHours() { return openingHours; }
    public void setOpeningHours(String openingHours) { this.openingHours = openingHours; }
}
