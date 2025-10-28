package com.delivrey.service;

import com.delivrey.entity.Delivery;
import java.util.*;

import org.springframework.stereotype.Service;

@Service("nearest")
public class NearestNeighborOptimizer implements TourOptimizer {

    @Override
    public List<Delivery> calculateOptimalTour(List<Delivery> deliveries) {
        List<Delivery> remaining = new ArrayList<>(deliveries);
        List<Delivery> ordered = new ArrayList<>();

        if (remaining.isEmpty()) return ordered;

        Delivery current = remaining.remove(0);

        while (!remaining.isEmpty()) {
            Delivery next = null;
            double minDistance = Double.MAX_VALUE;

            for (Delivery d : remaining) {
                double dist = distance(current, d);
                if (dist < minDistance) {
                    minDistance = dist;
                    next = d;
                }
            }

            if (next == null) break;
            ordered.add(next);
            remaining.remove(next);
            current = next;
        }


        return ordered;
    }

    private double distance(Delivery a, Delivery b) {
        double dx = a.getLatitude() - b.getLatitude();
        double dy = a.getLongitude() - b.getLongitude();
        return Math.sqrt(dx*dx + dy*dy);
    }
}
