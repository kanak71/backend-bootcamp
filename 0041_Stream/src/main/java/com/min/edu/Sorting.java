package com.min.edu;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.min.edu.beans.MockData;
import com.min.edu.dto.People;

//TODO 107 문자열 정렬(ASC, DESC)
public class Sorting {

	public static void main(String[] args) throws IOException {
		List<People> people = MockData.getPeople();
		
		List<String> sortASC = people.stream()
				.map(People::getFirstName)
				.sorted()
				.collect(Collectors.toList());
		//sortASC.forEach(System.out::println);
		
		List<String> sortDESC = people.stream()
				.map(People::getFirstName)
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		sortDESC.forEach(System.out::println);
		
		/*
		 * sort는 기본적으로 ASC뿐이 되지 않는다
		 * 따리서 비교 메소드를 사용해서 a b의 차이를 비교하여 다시 정렬하는 형태이거나
		 * 혹은 sort를 ASC한 후에 역으로 출력해서 새로운 객체로 만들어내는 방식을 사용
		 * 
		 * Comparator.naturalOrder() : 자연정렬 처리 방식
		 * 정렬 : 숫자 작은 -> 큰
		 * 		문자 "1", "11" "111" , "2"
		 * 		날짜 과거 -> 현재
		 */

	}

}
