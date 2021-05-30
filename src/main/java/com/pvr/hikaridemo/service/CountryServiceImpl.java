package com.pvr.hikaridemo.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvr.hikaridemo.convertor.CountryDtoConvertor;
import com.pvr.hikaridemo.json.Country;
import com.pvr.hikaridemo.model.CountryModel;
import com.pvr.hikaridemo.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	private final CountryRepository countryRepository;

	@Autowired
	public CountryServiceImpl(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@Override
	public List<Country> getAllCountries() {

		return CountryDtoConvertor.toCountryList(countryRepository.findAll());
	}

	@Override
	public Country getCountry(String countryId) {
		return CountryDtoConvertor.toCountry(countryRepository.findById(countryId).orElse(null));
	}

	@Override
	public Country saveCountry(Country country) {
		return CountryDtoConvertor.toCountry(countryRepository.save(CountryDtoConvertor.toCountryModel(country)));
	}

	@Override
	public Country updateCountry(Country country) {
		CountryModel countryModel = countryRepository.findById(country.getCountry_id()).orElse(null);

		if (countryModel == null) {
			return CountryDtoConvertor.toCountry(countryRepository.save(CountryDtoConvertor.toCountryModel(country)));
		} else {
			countryModel.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
			return CountryDtoConvertor.toCountry(countryRepository.save(countryModel));
		}
	}

}
