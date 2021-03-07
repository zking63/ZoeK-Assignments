package com.codingdojo.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.repositories.LicenseRepo;
import com.codingdojo.driverslicense.repositories.PersonRepo;

@Service
public class DriversService {
	private final PersonRepo personrepo;
	private final LicenseRepo licenserepo;
	
	public DriversService(PersonRepo personrepo, LicenseRepo licenserepo) {
		this.personrepo = personrepo;
		this.licenserepo = licenserepo;
	}
	public Person getPerson(Long id) {
		return personrepo.findById(id).orElse(null);
	}
	public License getLicense(Long id) {
		return licenserepo.findById(id).orElse(null);
	}
	public List<Person> getPeople() {
		return personrepo.findAll();
	}
	public Person createPerson(Person a) {
		return personrepo.save(a);
	}
	public List<Person> getUnlicensedPeople() {
		return personrepo.findByLicenseIdIsNull();
	}
	public License createLicense(License l) {
		l.setNumber(this.generateLicenseNumber());
		return licenserepo.save(l);
	}
	public int generateLicenseNumber() {
		License l = licenserepo.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		int largestNumber = l.getNumber();
		largestNumber++;
		return (largestNumber);
	}
}
