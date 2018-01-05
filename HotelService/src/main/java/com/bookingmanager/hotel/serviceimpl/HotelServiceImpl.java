package com.bookingmanager.hotel.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingmanager.hotel.dto.AmenityDTO;
import com.bookingmanager.hotel.dto.HotelDTO;
import com.bookingmanager.hotel.entity.Amenities;
import com.bookingmanager.hotel.entity.Hotel;
import com.bookingmanager.hotel.enums.Operation;
import com.bookingmanager.hotel.repository.HotelRepository;
import com.bookingmanager.hotel.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private HotelRepository repository;
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public void createOrUpdateHotel(HotelDTO hotelDTO) {
		Hotel hotel = null;
		hotel = repository.findByNameAndCityCityName(hotelDTO.getName(), hotelDTO.getCity().getCityName());

		if (null != hotel) {
			hotelDTO.setId(hotel.getId());
		}
		mapper.map(hotelDTO, hotel);
		System.out.println("Contact no here is ?>>>>> "+hotel.getContactNo()+" description hewre is "+ hotel.getDescription());
		repository.save(hotel);
	}

	/*
	 * @Override public Hotel updateHotel(Hotel hotelDTO) { // TODO Auto-generated
	 * method stub return null; }
	 */

	@Override
	public HotelDTO getHotelByName(String hotelName) {
		Hotel hotel = repository.findByName(hotelName);
		HotelDTO dto = mapper.map(hotel, HotelDTO.class);
		return dto;
	}

	@Override
	public HotelDTO getHotelById(Long hotelId) {
		System.out.println(hotelId + " Entered value");
		Hotel hotel = repository.findOne(hotelId);
		HotelDTO dto = mapper.map(hotel, HotelDTO.class);
		return dto;
	}

	@Override
	public List<HotelDTO> getHotelByCity(String cityName) {
		List<Hotel> hotels = repository.findByCityCityName(cityName);
		List<HotelDTO> dto = new ArrayList<>();
		for (Hotel h : hotels) {
			dto.add(mapper.map(h, HotelDTO.class));
		}
		return dto;
	}

	@Override
	public void addOrUpdateAminity(Operation operation, AmenityDTO amenityDTO, HotelDTO hotelDTO) {
		Hotel hotel = mapper.map(hotelDTO, Hotel.class);
		Amenities amenity = mapper.map(amenityDTO, Amenities.class);
		if (operation == Operation.ADD) {
			hotel.getAminitySet().add(amenity);
		} else {
			hotel.getAminitySet().remove(amenity);
		}
		repository.save(hotel);
	}
}