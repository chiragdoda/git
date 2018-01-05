package com.bookingmanager.country.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingmanager.country.entity.Country;
import com.bookingmanager.country.repository.CountryRepository;
import com.bookingmanager.country.service.ICountryService;
import com.bookingmanager.vo.CountryVO;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private CountryRepository repository;
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public CountryVO getCountryDetail(String name) {
		Country country = repository.findByCountryName(name);
		CountryVO vo = mapper.map(country, CountryVO.class);
		System.out.println(country.getCountryName());
		System.out.println(vo.getName());
		return vo;
	}

	@Override
	public List<CountryVO> getAllCountries() {
		List<Country> country = repository.findAll();
		List<CountryVO> list = new ArrayList<>();
		for (Country c : country) {
			list.add(mapper.map(c, CountryVO.class));
		}
		return list;
	}

	@Override
	public void addNewCountry(CountryVO vo) {
		Country country = mapper.map(vo, Country.class);
		repository.save(country);
	}

}
