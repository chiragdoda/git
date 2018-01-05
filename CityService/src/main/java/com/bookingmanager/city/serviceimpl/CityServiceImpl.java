package com.bookingmanager.city.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingmanager.city.dto.CityDTO;
import com.bookingmanager.city.entity.City;
import com.bookingmanager.city.repository.CityRepository;
import com.bookingmanager.city.service.ICityService;
import com.bookingmanager.vo.CityVO;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	private CityRepository repository;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public void updateCity(CityDTO cityDTO) {
		City city = mapper.map(cityDTO, City.class);
		repository.save(city);
	}

	@Override
	public CityDTO getCityByName(String name) {
		City c = repository.findByCityName(name);
		CityDTO dto = mapper.map(c, CityDTO.class);
		return dto;
	}

	@Override
	public CityDTO getCityById(Long cityId) {
		City c = repository.findOne(cityId);
		CityDTO dto = mapper.map(c, CityDTO.class);
		return dto;
	}

	@Override
	public List<CityDTO> getCitiesByCountryName(String countryName) {
		List<City> city = repository.findByCountryCountryName(countryName);
		List<CityDTO> vo = new ArrayList<>();
		for (City c : city) {
			vo.add(mapper.map(c, CityDTO.class));
		}
		return vo;
	}
}
