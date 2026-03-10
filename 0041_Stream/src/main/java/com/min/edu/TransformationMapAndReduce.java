package com.min.edu;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.min.edu.beans.MockData;
import com.min.edu.dto.People;
import com.min.edu.dto.PeopleDto;

//TODO 108 새로운 객체로 변환 People -> PeopleDto
public class TransformationMapAndReduce {
	
	public static void main(String[] args) throws IOException {
		List<People> people = MockData.getPeople();
		System.out.println(people.get(0));
		
		List<PeopleDto> dtos = people.stream()
				.filter(p -> p.getAge() > 20)
				.map(PeopleDto::map)
				.collect(Collectors.toList());
		dtos.forEach(System.out::println);
		
	}
	

}
