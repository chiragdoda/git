package com.bookingmanager.city.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingmanager.city.dto.CityDTO;
import com.bookingmanager.city.service.ICityService;
import com.bookingmanager.vo.CityVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/city")
@Api(value = "City")
public class CityController {

	@Autowired
	private ICityService cityService;
	@Autowired
	private DozerBeanMapper mapper;

	@ApiOperation(value = "To create new city in a country", notes = "This resource provides support to create new city in a particular country")
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addCity(@RequestBody CityVO city, @RequestParam("countryName") String countryName) {

		// Country country = countryServcice.getCountryByName(countryName);

		// city.setCountry(country);
		// Fetch CountryVO and convert it to DTO
		CityDTO dto = mapper.map(city, CityDTO.class);
		cityService.updateCity(dto);

	}

	@ApiOperation(value = "To fetch cities in a country", notes = "This resource provides all cities in a particular country")
	@RequestMapping(value = "/country/{countryName}", method = RequestMethod.GET)
	public List<CityVO> getCitiesByCountryName(@PathVariable("countryName") String countryName) {
		List<CityDTO> dto = cityService.getCitiesByCountryName(countryName);
		List<CityVO> vo = new ArrayList<>();
		for (CityDTO d : dto) {
			vo.add(mapper.map(d, CityVO.class));
		}
		return vo;
	}

	@ApiOperation(value = "To fetch city detail.", notes = "This resource provides city specific details")
	@RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
	public CityVO getCityDetailByCityName(@PathVariable("cityName") String cityName) {
		CityDTO dto = cityService.getCityByName(cityName);
		CityVO vo = mapper.map(dto, CityVO.class);
		return vo;
	}
}
