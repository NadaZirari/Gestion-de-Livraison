package com.delivrey.service;

import com.delivrey.entity.Delivery;
import com.delivrey.util.GeoUtils;
import java.util.*;

import org.springframework.stereotype.Service;


@Service("clarke")

public class ClarkeWrightOptimizer implements TourOptimizer {

    @Override
    public List<Delivery> calculateOptimalTour(List<Delivery> deliveries) {
        // Simple simulation de fusion par "économie"
        List<Delivery> sorted = new ArrayList<>(deliveries);
        sorted.sort(Comparator.comparingDouble(Delivery::getLatitude));
        return sorted;
    }
}
