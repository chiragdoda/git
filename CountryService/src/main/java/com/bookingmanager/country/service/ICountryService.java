package com.bookingmanager.country.service;

import java.util.List;

import com.bookingmanager.country.entity.Country;
import com.bookingmanager.vo.CountryVO;

public interface ICountryService {

	CountryVO getCountryDetail(String name);

	List<CountryVO> getAllCountries();

	void addNewCountry(CountryVO country);
}
