package com.codingdojo.driverslicense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.driverslicense.models.Person;

public interface PersonRepo extends CrudRepository<Person, Long>{
	List<Person> findAll();
	@Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL", nativeQuery=true)
	List<Person> findByNoLicense();
	
	List<Person> findByLicenseIdIsNull();
}
