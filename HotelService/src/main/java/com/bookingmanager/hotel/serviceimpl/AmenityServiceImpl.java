package com.bookingmanager.hotel.serviceimpl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingmanager.hotel.dto.AmenityDTO;
import com.bookingmanager.hotel.entity.Amenities;
import com.bookingmanager.hotel.repository.AmenityRepository;
import com.bookingmanager.hotel.service.IAmenityService;
@Service
public class AmenityServiceImpl implements IAmenityService {


	@Autowired
	private AmenityRepository repository;
	@Autowired
	private DozerBeanMapper mapper;
	@Override
	public AmenityDTO getAminityByName(String name) {
		Amenities a = repository.findByName(name);
		AmenityDTO dto = mapper.map(a, AmenityDTO.class);
		return dto;
	}

}
