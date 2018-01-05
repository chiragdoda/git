package com.bookingmanager.hotel.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookingmanager.hotel.dto.AmenityDTO;
import com.bookingmanager.hotel.dto.CityDTO;
import com.bookingmanager.hotel.dto.HotelDTO;
import com.bookingmanager.hotel.entity.Amenities;
import com.bookingmanager.hotel.entity.Hotel;
import com.bookingmanager.hotel.enums.Operation;
import com.bookingmanager.hotel.service.IAmenityService;
import com.bookingmanager.hotel.service.IHotelService;
import com.bookingmanager.vo.AmenityVO;
import com.bookingmanager.vo.CityVO;
import com.bookingmanager.vo.HotelVO;

import io.swagger.annotations.Api;

@RestController
// @ConfigurationProperties("classpath:application.properties")
@RequestMapping(value = "/hotel")
@Api(value = "Hotel", description = "This controller is meant for Hotel Booking")
public class HotelController {

	@Autowired
	private RestTemplate restCaller;

	@Value("${city.service.path}")
	private String url;

	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IAmenityService amenityService;

	@Autowired
	DozerBeanMapper mapper;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void createHotel(@RequestBody HotelVO hotel) {

		// TO-DO This call has to be done through discovery
		// service--------------->>>>>>>>>>>>>
		String cityServiceUrl = url + "/city/" + hotel.getCityName();
		ResponseEntity<CityVO> response = restCaller.getForEntity(cityServiceUrl, CityVO.class);
		CityVO vo = response.getBody();

		// TO-DO This call has to be done through discovery
		// service--------------->>>>>>>>>>>>>

		CityDTO citydto = mapper.map(vo, CityDTO.class);
		HotelDTO hoteldto = mapper.map(hotel, HotelDTO.class);
		hoteldto.setCity(citydto);
		hotelService.createOrUpdateHotel(hoteldto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateHotel(@RequestBody HotelVO hotel) {
		HotelDTO hoteldto = mapper.map(hotel, HotelDTO.class);
		/*if (hotelService.getHotelById(hoteldto.getId()) == null) {

			// TO-DO throw an exception
		}*/
		// TO-DO This call has to be done through discovery
		// service--------------->>>>>>>>>>>>>
		String cityServiceUrl = url + "/city/" + hotel.getCityName();
		ResponseEntity<CityVO> response = restCaller.getForEntity(cityServiceUrl, CityVO.class);
		CityVO vo = response.getBody();

		// TO-DO This call has to be done through discovery
		// service--------------->>>>>>>>>>>>>

		CityDTO citydto = mapper.map(vo, CityDTO.class);
		hoteldto.setCity(citydto);
		hotelService.createOrUpdateHotel(hoteldto);
	}

	@RequestMapping(value = "/city/{cityName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HotelVO> getHotelByCity(@PathVariable("cityName") String cityName) {
		List<HotelDTO> dto = hotelService.getHotelByCity(cityName);
		List<HotelVO> vo = new ArrayList<>();
		for (HotelDTO d : dto) {
			vo.add(mapper.map(d, HotelVO.class));
		}
		return vo;
	}

	@RequestMapping(value = "/{hotelId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelVO getHotelById(@PathVariable("hotelId") String hotelId) {
		HotelDTO dto = hotelService.getHotelById(Long.valueOf(hotelId));
		HotelVO vo = mapper.map(dto, HotelVO.class);
		return vo;
	}

	@RequestMapping(value = "/amenities/{hotelName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<AmenityVO> getAminitiesByHotel(@PathVariable("hotelName") String hotelName) {
		Set<AmenityDTO> dto = hotelService.getHotelByName(hotelName).getAmenities();
		Set<AmenityVO> vo = new HashSet<>();
		for (AmenityDTO d : dto) {
			vo.add(mapper.map(d, AmenityVO.class));
		}
		return vo;
	}

	@RequestMapping(value = "/{aminityName}/{hotelName}/{operation}", method = RequestMethod.PUT)
	public void addOrUpdateAminities(@PathVariable("aminityName") String aminityName,
			@PathVariable("hotelName") String hotelName, @PathVariable("operation") Operation operation) {
		HotelDTO hotel = hotelService.getHotelByName(hotelName);
		AmenityDTO aminities = amenityService.getAminityByName(aminityName);
		hotelService.addOrUpdateAminity(operation, aminities, hotel);
	}
}
