package com.bookingmanager.country.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "HOTEL")
public class Hotel {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CONTACT")
	private String contactNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ACTIVE_FLAG")
	@Type(type="yes_no")
	private boolean active;
	@ManyToOne
	@JoinColumn(name="city_id_fk")
	private City city;
	@ManyToMany
	@JoinTable(name="HOTEL_AMENITIES_MAPPING", joinColumns= { @JoinColumn(name = "hotel_id") }, inverseJoinColumns = {
			@JoinColumn(name = "amenity_id") })
	private Set<Amenities> aminitySet;

	public Set<Amenities> getAminitySet() {
		return aminitySet;
	}

	public void setAminitySet(Set<Amenities> aminitySet) {
		this.aminitySet = aminitySet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
