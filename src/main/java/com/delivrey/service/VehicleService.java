package com.delivrey.service;

import com.delivrey.entity.Vehicle;
import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(Long id);

    Vehicle saveVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Long id, Vehicle vehicle);

    void deleteVehicle(Long id);
}
