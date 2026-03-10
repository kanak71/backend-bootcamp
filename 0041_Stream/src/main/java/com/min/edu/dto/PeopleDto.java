package com.min.edu.dto;

//TODO 004 People의 일부분을 사용하기 위한 객체, 프로덕션 DTO
public class PeopleDto {
	
	private final Integer id;
	private final String name;
	private final Integer age;
	
	public PeopleDto(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}
	
	public static PeopleDto map(People people) {
		return new PeopleDto(people.getId(), people.getFirstName(), people.getAge());
	}
	
	

}
