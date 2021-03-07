package com.codingdojo.driverslicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.driverslicense.models.License;

public interface LicenseRepo extends CrudRepository<License, Long>{
	List<License> findAll();
	public License findTopByOrderByNumberDesc();
}
