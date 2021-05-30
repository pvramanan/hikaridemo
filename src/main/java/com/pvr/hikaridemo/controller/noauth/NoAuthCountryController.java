package com.pvr.hikaridemo.controller.noauth;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvr.hikaridemo.controller.AbstractCountryController;
import com.pvr.hikaridemo.json.Apiuser;
import com.pvr.hikaridemo.json.Country;
import com.pvr.hikaridemo.service.CountryService;

import io.swagger.annotations.Api;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/noauth")
@Api(value = "no auth controller" ,tags = "No auth country controller")
@Qualifier(value = "NoAuthCountryController")
public class NoAuthCountryController extends AbstractCountryController
{

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public List<Country> getAllCountry(Apiuser apiuser) {
		
		return countryService.getAllCountries();
	}

	
	@Override
	public Country getCountry(String countryId, Apiuser apiuser) {
		return countryService.getCountry(countryId);
	}

	@Override
	public Country saveCountry(Country country, Apiuser apiuser) {
		return countryService.saveCountry(country);
	}
	
	@Override
	public Country updateCountry(Country country, Apiuser apiuser) {
		return countryService.updateCountry(country);
	}
	
	@Override
	public Apiuser getApiuser() {
		System.out.println(request.getHeader("sub"));
		return null;
	}






}
