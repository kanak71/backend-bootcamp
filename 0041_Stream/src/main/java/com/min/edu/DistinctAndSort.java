package com.min.edu;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//TODO 103 중복제거후 List로 출력
public class DistinctAndSort {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,1,2,2,2,2,3,3,3,3,4,4,4,4,4,5,5,5,5);
		List<Integer> distinctList = numbers.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println("처음 List의 개수 : " + numbers.size());
		System.out.println("Stream List의 개수 : " + distinctList.size());
		
		//Set으로 출력(JCF만 된다)
		Set<Integer> distinctSet = numbers.stream()
				.collect(Collectors.toSet());
		System.out.println(distinctSet);
	}

}
