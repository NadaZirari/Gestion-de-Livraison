package com.delivrey.service.impl;

import com.delivrey.entity.Delivery;
import com.delivrey.entity.Tour;
import com.delivrey.service.TourOptimizer;
import com.delivrey.repository.TourRepository;
import com.delivrey.repository.DeliveryRepository;
import com.delivrey.service.TourService;
import com.delivrey.util.GeoUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Impl qui sera déclarée dans applicationContext.xml avec constructeur args:
 * (DeliveryRepository, TourRepository, nearestOptimizer, clarkeOptimizer)
 */
public class TourServiceImpl implements TourService {

    private final DeliveryRepository deliveryRepository;
    private final TourRepository tourRepository;
    private final TourOptimizer nearest;
    private final TourOptimizer clarke;

    public TourServiceImpl(DeliveryRepository deliveryRepository,
                           TourRepository tourRepository,
                           TourOptimizer nearest,
                           TourOptimizer clarke) {
        this.deliveryRepository = deliveryRepository;
        this.tourRepository = tourRepository;
        this.nearest = nearest;
        this.clarke = clarke;
    }

    @Override
    public List<Delivery> getOptimizedTour(Long tourId, String algorithm) {
        Optional<Tour> opt = tourRepository.findById(tourId);
        if (!opt.isPresent()) return new ArrayList<>();
        Tour tour = opt.get();

        // Build list with warehouse as first item (for Clarke-Wright impl above)
        List<Delivery> list = new ArrayList<>();
        // transform warehouse as Delivery-like object (or pass warehouse coords separately)
        com.delivrey.entity.Warehouse w = tour.getWarehouse();
        Delivery depot = new Delivery();
        depot.setLatitude(w.getLatitude());
        depot.setLongitude(w.getLongitude());
        depot.setAddress(w.getAddress());
        depot.setId(-1L); // pseudo-id for depot
        list.add(depot);
        list.addAll(tour.getDeliveries());

        if ("CW".equalsIgnoreCase(algorithm)) {
            return clarke.calculateOptimalTour(list);
        } else {
            return nearest.calculateOptimalTour(list);
        }
    }

    @Override
    public double getTotalDistance(Long tourId, String algorithm) {
        List<Delivery> route = getOptimizedTour(tourId, algorithm);
        if (route == null || route.size() < 2) return 0.0;
        double total = 0.0;
        // if depot is first element and last element not depot, add return to depot
        for (int i = 0; i < route.size() - 1; i++) {
            Delivery a = route.get(i);
            Delivery b = route.get(i + 1);
            total += GeoUtils.haversineKm(a.getLatitude(), a.getLongitude(), b.getLatitude(), b.getLongitude());
        }
        // Optionally add return to depot if last element isn't depot id -1
        return total;
    }
}
