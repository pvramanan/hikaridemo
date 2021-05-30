package com.pvr.hikaridemo.convertor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pvr.hikaridemo.json.Country;
import com.pvr.hikaridemo.model.CountryModel;

public class CountryDtoConvertor {

	public static List<Country> toCountryList(List<CountryModel> countryModels) {

		if (countryModels != null && countryModels.size() > 0) {
			List<Country> countries = new ArrayList<>();
			for (CountryModel countryModel : countryModels) {
				countries.add(toCountry(countryModel));
			}
			return countries;
		}
		return Collections.emptyList();

	}

	public static Country toCountry(CountryModel countryModel) {
		if(countryModel==null)
			return null;

		return new Country(countryModel.getCountry_id(), countryModel.getCountryName(),
				countryModel.getCreatedDate().toLocalDateTime().toLocalDate());
	}

	public static CountryModel toCountryModel(Country country) 
	{
		CountryModel model = new CountryModel();
		model.setCountry_id(country.getCountry_id());
		model.setCountryName(country.getCountry_name());
		model.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		model.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
		return model;

	}

	private CountryDtoConvertor() {
	}

}
