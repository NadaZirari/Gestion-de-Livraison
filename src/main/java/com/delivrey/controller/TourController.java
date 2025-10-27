package com.delivrey.controller;

import com.delivrey.service.TourService;
import com.delivrey.entity.Delivery;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/{id}/optimize")
    public List<Delivery> optimize(@PathVariable Long id, @RequestParam String algorithm) {
        return tourService.getOptimizedTour(id, algorithm);
    }
}
