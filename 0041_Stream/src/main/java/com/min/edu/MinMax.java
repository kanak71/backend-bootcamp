package com.min.edu;

import java.util.Comparator;
import java.util.List;

//TODO 106 최소값 최대값
public class MinMax {
	public static void main(String args[]) {
		
		List<Integer> numbers = List.of(1,2,3, 100, 23, 90, 99);
		Integer min = numbers.stream().min(Comparator.naturalOrder()).get();
		System.out.println("최소값 : " + min);
		
		Integer max = numbers.stream().max(Comparator.naturalOrder()).get();
		System.out.println("최대값 : " + max);

	}

}
