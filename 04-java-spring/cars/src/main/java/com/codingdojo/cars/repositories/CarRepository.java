package com.codingdojo.cars.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cars.models.Car;

//this is an interface because it is not a class, it can't be instantiated or made into an object

@Repository //lets java know this is a repository
public interface CarRepository extends CrudRepository<Car, Long>{
	//CRUD: create, read, update, delete
	//Crud repository takes 2 things in a constructor: type of object you want to do (car) and type of primary key (long)
	List<Car> findAll(); //this is the same as select * from cars, creating an arraylist for this.
}
