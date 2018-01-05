package com.bookingmanager.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingmanager.hotel.entity.Amenities;
@Repository
public interface AmenityRepository extends JpaRepository<Amenities, Long>{
	Amenities findByName(String name);
}
