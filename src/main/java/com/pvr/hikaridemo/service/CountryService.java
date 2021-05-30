package com.pvr.hikaridemo.service;

import java.util.List;

import com.pvr.hikaridemo.json.Country;

public interface CountryService {

	List<Country> getAllCountries();

	Country getCountry(String countryId);

	Country saveCountry(Country country);
	
	Country updateCountry(Country country);

}
