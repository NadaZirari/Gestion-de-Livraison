package com.delivrey.repository;

import com.delivrey.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	 Vehicle findByRegistrationNumber(String registrationNumber);
	 
}
