
package com.delivrey.controller;

import com.delivrey.entity.Warehouse;
import com.delivrey.repository.WarehouseRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private final WarehouseRepository repo;

    public WarehouseController(WarehouseRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Warehouse> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
    }

    @PostMapping
    public Warehouse create(@RequestBody Warehouse warehouse) {
        return repo.save(warehouse);
    }

    @PutMapping("/{id}")
    public Warehouse update(@PathVariable Long id, @RequestBody Warehouse w) {
        Warehouse existing = getById(id);
        existing.setAddress(w.getAddress());
        existing.setLatitude(w.getLatitude());
        existing.setLongitude(w.getLongitude());
        existing.setOpeningHours(w.getOpeningHours());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
