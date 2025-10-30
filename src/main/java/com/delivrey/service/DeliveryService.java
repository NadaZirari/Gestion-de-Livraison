package com.delivrey.service;

import com.delivrey.repository.DeliveryRepository;
import com.delivrey.entity.Delivery;
import java.util.List;

public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    // Injection via le constructeur (Spring XML s’en chargera)
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getDeliveriesByStatus(String status) {
        return deliveryRepository.findByStatus(status);
    }
}
