package com.codingdojo.cars.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //entity is anything going to database
@Table(name="cars") //what we are naming this in the table in mysql
public class Car {
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //saying ID field will auto increment whenever id is created
	private Long id;
	private String make;
	private String model;
	private int year;
	private String color;
	
	//we need to do 2 things: constructor (empty bean type + regular with fields) and getters and setters
	
	public Car() {
		//super(); this loads automatically, you don't need it
	}

	public Car(Long id, String make, String model, int year, String color) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
