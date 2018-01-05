package com.bookingmanager.city;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;

import com.bookingmanager.city.dto.CityDTO;
import com.bookingmanager.city.dto.CountryDTO;
import com.bookingmanager.city.entity.City;
import com.bookingmanager.vo.CityVO;

public class DozerTest {

	public static void main(String[] args) {/*
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(Arrays.asList("dozer.xml"));
		CityVO vo = new CityVO();
		vo.setCityName("Chirag Doda");
		vo.setCountryName("India");
		CityDTO dto = mapper.map(vo, CityDTO.class);
		System.out.println("hello " + dto.getCountry().getCountryName());
		
		//dto to entity
		CityDTO dto1 = new CityDTO();
		dto1.setCityName("Chicago");
		CountryDTO c = new CountryDTO();
		c.setCountryId(2L);
		c.setCountryName("USA");
		dto1.setCountry(c);
		
		City c1 = mapper.map(dto1, City.class);
		System.out.println(c1.getCountry().getCountryName());
	*/}
}
