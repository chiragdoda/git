package com.bookingmanager.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingmanager.hotel.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	List<Hotel> findByCityCityName(String name);
	Hotel findByName(String name);
	Hotel findByNameAndCityCityName(String name,String CityName);
}
