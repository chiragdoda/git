package com.bookingmanager.hotel.service;

import java.util.List;

import com.bookingmanager.hotel.dto.AmenityDTO;
import com.bookingmanager.hotel.dto.HotelDTO;
import com.bookingmanager.hotel.enums.Operation;

public interface IHotelService {

	void createOrUpdateHotel(HotelDTO hoteldto);

	// Hotel updateHotel(Hotel hotelDTO);

	HotelDTO getHotelByName(String hotelName);

	HotelDTO getHotelById(Long hotelId);

	List<HotelDTO> getHotelByCity(String cityName);

	void addOrUpdateAminity(Operation operation, AmenityDTO aminity, HotelDTO hotel);

}
