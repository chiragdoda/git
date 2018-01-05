package com.bookingmanager.city.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingmanager.city.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

	List<City> findByCountryCountryName(String name);

	City findByCityName(String cityName);

}
