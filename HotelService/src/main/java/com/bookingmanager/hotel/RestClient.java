package com.bookingmanager.hotel;

import org.springframework.web.client.RestTemplate;

import com.bookingmanager.vo.HotelVO;

public class RestClient {
	private static String url = "http://localhost:18086/hotel";

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		HotelVO vo = new HotelVO();
		vo.setHotelName("Mehfil Hotel");
		vo.setCityName("Fazilka");
		vo.setContactNo("9871037986");
//		vo.setDescription("Hotel and Beer Bar");
		vo.setActive(true);
		 restTemplate.put(url + "/update",vo);
		// restTemplate.postForLocation(url + "/update",vo);
//		restTemplate.patchForObject(url + "/update", vo, Void.class);
		// assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

}
