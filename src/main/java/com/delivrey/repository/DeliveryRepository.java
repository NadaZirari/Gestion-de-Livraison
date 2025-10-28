package com.delivrey.repository;

import com.delivrey.entity.Delivery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	
	
	 List<Delivery> findByStatus(String status);
}
