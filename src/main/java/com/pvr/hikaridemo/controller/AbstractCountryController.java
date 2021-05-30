package com.pvr.hikaridemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pvr.hikaridemo.json.Apiuser;
import com.pvr.hikaridemo.json.Country;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
public abstract class AbstractCountryController {

	private static final String URI_COUNTRY_COLLECTION = "/countries";

	@ApiOperation(notes = "This resource can be used to get all country details", value = "Perform the get all country details")
	@GetMapping(URI_COUNTRY_COLLECTION)
	@ApiResponses({ @ApiResponse(code = 200, message = "successfully return the list of county") })
	public List<Country> getAllCountry() {
		return getAllCountry(getApiuser());
	}

	@ApiOperation(notes = "This resource can be used to get country details", value = "Perform the get country details")
	@GetMapping(URI_COUNTRY_COLLECTION + "{id}")
	@ApiResponses({ @ApiResponse(code = 200, message = "successfully return the country details") })
	public Country getCountry(
			@ApiParam(value = "id of the country", required = true, defaultValue = "INR") @PathVariable(name = "id", required = true, value = "id") @Valid String countryId) {

		return getCountry(countryId, getApiuser());
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(notes = "This resource can be used to add country details", value = "Perform the get all country details")
	@PostMapping(URI_COUNTRY_COLLECTION)
	@ApiResponses({ @ApiResponse(code = 201, message = "successfully created county") })
	public Country saveCountry(@RequestBody Country country) {
		return saveCountry(country, getApiuser());
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(notes = "This resource can be used to update country details", value = "Perform the get all country details")
	@PutMapping(URI_COUNTRY_COLLECTION)
	@ApiResponses({ @ApiResponse(code = 200, message = "successfully return the list of county") })
	public Country updateCountry(@RequestBody Country country) {
		return updateCountry(country, getApiuser());
	}

	public abstract List<Country> getAllCountry(Apiuser apiuser);

	public abstract Country getCountry(String countryId, Apiuser apiuser);

	public abstract Country saveCountry(Country country, Apiuser apiuser);

	public abstract Country updateCountry(Country country, Apiuser apiuser);

	public abstract Apiuser getApiuser();
}
