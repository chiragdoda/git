package com.bookingmanager.city.service;

import java.util.List;

import com.bookingmanager.city.dto.CityDTO;
import com.bookingmanager.city.entity.City;
import com.bookingmanager.vo.CityVO;

public interface ICityService {

	CityDTO getCityByName(String name);

	List<CityDTO> getCitiesByCountryName(String countryName);

//	City addCity(CityDTO cityDTO);

	void updateCity(CityDTO cityDTO);

	CityDTO getCityById(Long cityId);

}
