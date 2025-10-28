package com.delivrey.service;

import com.delivrey.entity.*;
import com.delivrey.repository.*;
import com.delivrey.service.*;
import com.delivrey.entity.Tour;
import com.delivrey.entity.Delivery;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepo;
    private final TourOptimizer nearest;
    private final TourOptimizer clarke;

    public TourServiceImpl(TourRepository tourRepo, TourOptimizer nearest, TourOptimizer clarke) {
        this.tourRepo = tourRepo;
        this.nearest = nearest;
        this.clarke = clarke;
    }

    @Override
    public List<Delivery> getOptimizedTour(Long tourId, String algorithm) {
        Tour tour = tourRepo.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));
        List<Delivery> deliveries = tour.getDeliveries();

        if ("CLARKE_WRIGHT".equalsIgnoreCase(algorithm))
            return clarke.calculateOptimalTour(deliveries);
        else
            return nearest.calculateOptimalTour(deliveries);
    }

    @Override
    public double getTotalDistance(List<Delivery> deliveries) {
        double total = 0;
        for (int i = 0; i < deliveries.size() - 1; i++) {
            Delivery a = deliveries.get(i);
            Delivery b = deliveries.get(i + 1);
            double dx = a.getLatitude() - b.getLatitude();
            double dy = a.getLongitude() - b.getLongitude();
            total += Math.sqrt(dx * dx + dy * dy);
        }
        return total;
    }
}
