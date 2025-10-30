package com.delivrey.service.impl;

import com.delivrey.entity.Delivery;
import com.delivrey.entity.Tour;
import com.delivrey.repository.DeliveryRepository;
import com.delivrey.repository.TourRepository;
import com.delivrey.service.ClarkeWrightOptimizer;
import com.delivrey.service.NearestNeighborOptimizer;
import com.delivrey.service.TourOptimizer;
import com.delivrey.service.TourServiceImpl;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TourServiceImplTest {

    @Test
    void testGetOptimizedTourWithNearest() {
        DeliveryRepository deliveryRepo = mock(DeliveryRepository.class);
        TourRepository tourRepo = mock(TourRepository.class);
        TourOptimizer nearest = new NearestNeighborOptimizer();
        TourOptimizer clarke = new ClarkeWrightOptimizer();

        TourServiceImpl service = new TourServiceImpl(deliveryRepo, tourRepo, nearest, clarke);

        Tour tour = new Tour();
        tour.setDeliveries(new ArrayList<>());
        when(tourRepo.findById(1L)).thenReturn(Optional.of(tour));

        List<Delivery> result = service.getOptimizedTour(1L, "NN");
        assertNotNull(result);
    }

    @Test
    void testGetTotalDistanceEmptyTour() {
        DeliveryRepository deliveryRepo = mock(DeliveryRepository.class);
        TourRepository tourRepo = mock(TourRepository.class);
        TourOptimizer nearest = new NearestNeighborOptimizer();
        TourOptimizer clarke = new ClarkeWrightOptimizer();

        TourServiceImpl service = new TourServiceImpl(deliveryRepo, tourRepo, nearest, clarke);

        Tour tour = new Tour();
        tour.setDeliveries(new ArrayList<>());
        when(tourRepo.findById(1L)).thenReturn(Optional.of(tour));

        double distance = service.getTotalDistance(1L, "NN");
        assertEquals(0.0, distance);
    }

    @Test
    void testGetTotalDistanceWithDeliveries() {
        DeliveryRepository deliveryRepo = mock(DeliveryRepository.class);
        TourRepository tourRepo = mock(TourRepository.class);
        TourOptimizer nearest = new NearestNeighborOptimizer();
        TourOptimizer clarke = new ClarkeWrightOptimizer();

        TourServiceImpl service = new TourServiceImpl(deliveryRepo, tourRepo, nearest, clarke);

        Delivery depot = new Delivery();
        depot.setId(-1L);
        depot.setLatitude(0.0);
        depot.setLongitude(0.0);

        Delivery d1 = new Delivery();
        d1.setId(1L);
        d1.setLatitude(1.0);
        d1.setLongitude(0.0);

        List<Delivery> deliveries = new ArrayList<>();
        deliveries.add(d1);

        Tour tour = new Tour();
        tour.setDeliveries(deliveries);
        when(tourRepo.findById(1L)).thenReturn(Optional.of(tour));

        double distance = service.getTotalDistance(1L, "NN");
        assertTrue(distance > 0.0);
    }
}
