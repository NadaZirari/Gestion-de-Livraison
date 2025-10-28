package com.delivrey.controller;
import com.delivrey.entity.Vehicle;
import com.delivrey.repository.VehicleRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleRepository repo;

    public VehicleController(VehicleRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return repo.save(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id, @RequestBody Vehicle v) {
        Vehicle existing = getById(id);
        existing.setRegistrationNumber(v.getRegistrationNumber());
        existing.setType(v.getType());
        existing.setMaxDeliveries(v.getMaxDeliveries());
        existing.setMaxWeight(v.getMaxWeight());
        existing.setMaxVolume(v.getMaxVolume());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
