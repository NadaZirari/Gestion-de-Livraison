package com.delivrey.service;

import com.delivrey.entity.Warehouse;
import com.delivrey.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    private final WarehouseRepository repository;

    public WarehouseService(WarehouseRepository repository) {
        this.repository = repository;
    }

    public List<Warehouse> getAllWarehouses() {
        return repository.findAll();
    }

    public Warehouse getWarehouseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        return repository.save(warehouse);
    }

    public Warehouse updateWarehouse(Long id, Warehouse updatedWarehouse) {
        Warehouse existing = getWarehouseById(id);
        existing.setAddress(updatedWarehouse.getAddress());
        existing.setLatitude(updatedWarehouse.getLatitude());
        existing.setLongitude(updatedWarehouse.getLongitude());
        existing.setOpeningHours(updatedWarehouse.getOpeningHours());
        return repository.save(existing);
    }

    public void deleteWarehouse(Long id) {
        repository.deleteById(id);
    }
}
