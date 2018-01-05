package com.bookingmanager.hotel.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class City {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_SEQ")
	@SequenceGenerator(name = "CITY_SEQ", sequenceName = "city_seq")
	private long id;
	@Column(name = "name")
	private String cityName;

	@ManyToOne
	@JoinColumn(name="COUNTRY_ID_FK")
	private Country country;


	public City() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
