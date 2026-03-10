package com.min.edu;

import java.util.Objects;

public class StudentDto {
	
	private String name;
	private int age;
	
	public StudentDto(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDto other = (StudentDto) obj;
		return age == other.age && Objects.equals(name, other.name);
	}



	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", age=" + age + "]";
	}
	
	
	
	

}
