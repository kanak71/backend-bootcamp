package com.min.edu.dto;

//TODO 002 people.json 파일과 대응되는 java 은닉화 객체
public class People {
	
	private final Integer id;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String gender;
	private final Integer age;
	
	public People(Integer id, String firstName, String lastName, String email, String gender, Integer age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	

}
