package com.bookingmanager.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingmanager.country.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	Country findByCountryName(String countryName);
}
