package com.bookingmanager.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingmanager.country.service.ICountryService;
import com.bookingmanager.vo.CountryVO;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	@Autowired
	private ICountryService countryService;

	@RequestMapping(value = "/getCountry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CountryVO getCountryByName(@RequestParam("name") String name) {
		return countryService.getCountryDetail(name);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CountryVO> getAllCountries() {
		return countryService.getAllCountries();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addNewCountry(CountryVO country) {
		countryService.addNewCountry(country);
	}
}
