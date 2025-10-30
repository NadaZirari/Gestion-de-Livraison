package com.delivrey.repository;

import com.delivrey.entity.Tour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TourRepository extends JpaRepository<Tour, Long> {
	
    List<Tour> findByVehicleId(Long vehicleId);
}
