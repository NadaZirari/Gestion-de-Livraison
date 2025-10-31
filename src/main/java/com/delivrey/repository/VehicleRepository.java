package com.delivrey.repository;

import com.delivrey.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;




public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	 Vehicle findByRegistrationNumber(String registrationNumber);
	 
}
