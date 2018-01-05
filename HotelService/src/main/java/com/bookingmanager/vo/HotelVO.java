package com.bookingmanager.vo;

import java.util.Set;

public class HotelVO {

	private String hotelName;
	private String cityName;
	private String countryName;
	private boolean active;
	private String contactNo;
	private String description;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	private Set<AmenityVO> amenities;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Set<AmenityVO> getAmenities() {
		return amenities;
	}

	public void setAmenities(Set<AmenityVO> amenities) {
		this.amenities = amenities;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
