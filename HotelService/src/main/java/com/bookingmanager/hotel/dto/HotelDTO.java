package com.bookingmanager.hotel.dto;

import java.util.Set;

public class HotelDTO {

	private Long id;
	private String name;
	private String contact;
	private String description;
	private boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private CityDTO city;
	private Set<AmenityDTO> amenities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityDTO getCity() {
		return city;
	}

	public void setCity(CityDTO city) {
		this.city = city;
	}

	public Set<AmenityDTO> getAmenities() {
		return amenities;
	}

	public void setAmenities(Set<AmenityDTO> amenities) {
		this.amenities = amenities;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
