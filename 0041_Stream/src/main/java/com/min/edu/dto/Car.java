package com.min.edu.dto;

//TODO 003 cars.json파일과 대응되는 java 객체
public class Car {
	
	private final Integer id;
	private final String make;
	private final String model;
	private final Double price;
	private final Integer year;
	private final String color;
	
	public Car(Integer id, String make, String model, Double price, Integer year, String color) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.price = price;
		this.year = year;
		this.color = color;
	}

	public Integer getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getYear() {
		return year;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", price=" + price + ", year=" + year
				+ ", color=" + color + "]";
	}
	
	
	

}
