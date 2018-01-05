package com.bookingmanager.hotel.service;

import com.bookingmanager.hotel.dto.AmenityDTO;

public interface IAmenityService {

	AmenityDTO getAminityByName(String name);
	
}
