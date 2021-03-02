package com.codingdojo.cars.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.cars.models.Car;
import com.codingdojo.cars.repositories.CarRepository;

@Service //let's spring know this is a service class
public class CarService {
	//dependency injections: our service talks to our repository, repository talks to the database. you need access to the repository methods via dependency injection.
	
	//on this file we dependency injected by making an attribute and a constructor but there is a faster way to do this in the homecontroller.
	private CarRepository cRepo; //attribute
	
	public CarService(CarRepository repo) { //constructor
		this.cRepo = repo;
	}
	
	//CRUD commands v
	//Get all cars
	public List<Car> getAllCars(){
		return this.cRepo.findAll();
	}
	//Get one car
	public Car getSingleCar(Long id) {
		return this.cRepo.findById(id).orElse(null); //this returns optional object (optional is a superclass from java);this means they're going to find it or not, that's why we say orElse null. It keeps it from going out of bounds.
	}
	
	//Create a car
	public Car createCar(Car newCar) {
		return this.cRepo.save(newCar); //save is how you save to database
	}
	
	//Delete a car
	public void deleteCar(Long id) {
		this.cRepo.deleteById(id);
	}
}
