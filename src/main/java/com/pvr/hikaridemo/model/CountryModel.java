package com.pvr.hikaridemo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryModel 
{

	@Id 
	@Column(name = "country_id")
	public String country_id;
	
	@Column(name = "country_name")
	public String countryName;
	
	@Column(name = "created_on")
	public Timestamp createdDate;
	
	@Column(name = "modified_on")
	public Timestamp modifiedDate;
	
	
	public CountryModel() {
		super();
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	
	
}
