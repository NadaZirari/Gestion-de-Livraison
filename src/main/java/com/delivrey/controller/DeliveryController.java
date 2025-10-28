package com.delivrey.controller;

import com.delivrey.entity.Delivery;
import com.delivrey.repository.DeliveryRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @GetMapping
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Delivery getById(@PathVariable Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
    }

    @PostMapping
    public Delivery create(@RequestBody Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @PutMapping("/{id}")
    public Delivery update(@PathVariable Long id, @RequestBody Delivery delivery) {
        Delivery existing = getById(id);
        existing.setAddress(delivery.getAddress());
        existing.setLatitude(delivery.getLatitude());
        existing.setLongitude(delivery.getLongitude());
        existing.setVolume(delivery.getVolume());
        existing.setWeight(delivery.getWeight());
        existing.setTimeWindow(delivery.getTimeWindow());
        existing.setStatus(delivery.getStatus());
        return deliveryRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deliveryRepository.deleteById(id);
    }
}
