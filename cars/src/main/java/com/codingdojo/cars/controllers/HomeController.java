package com.codingdojo.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.cars.models.Car;
import com.codingdojo.cars.services.CarService;


@RestController
public class HomeController {
	
	//controller needs service methods
	//dependency injection
	@Autowired
	private CarService cService;
	
	@GetMapping("/")
	public List<Car> index(){
		return this.cService.getAllCars();
	}
	
	@GetMapping("/{id}")
	public Car getCar(@PathVariable("id") Long id) {
		return this.cService.getSingleCar(id);
	}
	
	@PostMapping("/")
	public Car create(Car car) {
		return this.cService.createCar(car);
	}
	
}
