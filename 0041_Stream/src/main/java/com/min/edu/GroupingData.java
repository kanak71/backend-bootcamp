package com.min.edu;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.min.edu.beans.MockData;
import com.min.edu.dto.Car;

//TODO 104 같은 Car 제조사를 통해서 Map<String, List>로 생성
public class GroupingData {

	public static void main(String[] args) throws IOException {
		Map<String, List<Car>> map = MockData.getCar()
				.stream()
				.collect(Collectors.groupingBy(Car::getMake));
		
		//Map<key,value>를 출력하기 위해서 keySet 혹은 entrySet을 통해서 출력해야만 했다
		map.forEach((s,cars) -> {
			System.out.println("제조사 : " + s);
			cars.forEach(System.out::println);	//속해있는 List의 DTO 객체를 하나씩 출력
			System.out.println("==".repeat(30));
			
		});
		
		//List에서 같은 값을 가지고 있는 개수를 조회
		//개미수열
		//회계프로그램, 주물발주된 제품에서 몇개를 이번에 주문, 발주했는지 파악할때
		//엑셀에서 읽어 그 행을 추출하고 -> 각 제품이 중복 값
		List<String> names = List.of(
				"알렉스",
				"홍길동",
				"코코아",
				"코코아",
				"홍길동");
		Map<String, Long> mapName = names.stream()
				.collect(Collectors.groupingBy(
						Function.identity(),
						Collectors.counting()
						));
		System.out.println(mapName);
		
		
	}

}
