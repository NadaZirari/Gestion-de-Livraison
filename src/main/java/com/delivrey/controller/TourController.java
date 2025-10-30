package com.delivrey.controller;

import com.delivrey.dto.DeliveryDTO;
import com.delivrey.entity.Delivery;
import mapper.DeliveryMapper;
import com.delivrey.service.TourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * NOTE: this class must be declared as bean in applicationContext.xml:
 * <bean id="tourController" class="com.delivrey.controller.TourController">
 *     <constructor-arg ref="tourService"/>
 * </bean>
 *
 * Methods use mapping annotations; ensure <mvc:annotation-driven/> is enabled in XML.
 */
@RequestMapping("/api/tours")
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/{tourId}/optimize")
    @ResponseBody
    public List<DeliveryDTO> optimize(@PathVariable("tourId") Long tourId,
                                      @RequestParam(name = "algo", defaultValue = "NN") String algo) {
        List<Delivery> optimized = tourService.getOptimizedTour(tourId, algo);
        return optimized.stream().map(DeliveryMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{tourId}/distance")
    @ResponseBody
    public double distance(@PathVariable("tourId") Long tourId,
                           @RequestParam(name = "algo", defaultValue = "NN") String algo) {
        return tourService.getTotalDistance(tourId, algo);
    }
}
