package com.delivrey.service;

import com.delivrey.entity.*;
import java.util.List;

public interface TourService {

	
	List<Delivery> getOptimizedTour(Long tourId, String algorithm);
    double getTotalDistance(List<Delivery> deliveries);
    
}
