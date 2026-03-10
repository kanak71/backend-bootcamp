package com.min.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.min.edu.beans.MockData;
import com.min.edu.dto.People;

//TODO 101 일반연산과 Stream 연산의 비교
public class GettingStarted {
	
	public static void main(String[] args) throws IOException {
		//조회 조건 : 나이가 18세 미만인 사람을 10명만 추출하기
		
		//1. 이전 연산 방식
		List<People> people = MockData.getPeople();	//checked Exception이기 때문에 사용하는 곳에서 예외처리
		List<People> youngPeople = new ArrayList<People>();
		
		int limit = 10;
		int counter = 0;
		
		for (People p : people) {
			if(p.getAge() <= 18) {
				youngPeople.add(p);
				counter++;
				
				if(counter == limit) {
					break;
				}
			}
		}
		youngPeople.forEach(System.out::println);
		
		//Stream 좋긴 한데..... 문제도 있어 선택된 객체를 선별적으로 가지고 올 수 있다 -----------------
		List<People> youngPeopleStream = people
				.stream()
				.filter(p->p.getAge() <= 18)	//조선을 처리 if문의 역할 
				.limit(10)
				.collect(Collectors.toList());
		
		youngPeopleStream.forEach(System.out::println);
		
		//이전방식의 for문
		for(int i=0; i<=10; i++) {
			System.out.println(i);
		}
		
		//Stream을 통한 foreach 출력
		
		IntStream.range(0, 10).forEach(System.out::println);
				
	}

}
