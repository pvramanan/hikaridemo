package com.pvr.hikaridemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pvr.hikaridemo.model.CountryModel;

public interface CountryRepository extends CrudRepository<CountryModel, String> {

	List<CountryModel> findAll();

}
