package com.min.edu;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.min.edu.beans.MockData;
import com.min.edu.dto.People;

//TODO 102 Stream 기본 연산 문법
public class StreamProcess {

	public static void main(String[] args) throws IOException {
		//People에서 email만을 추출하고 싶다
		List<String> emails = MockData.getPeople()
				.stream()
				.map(People::getEmail)
				.collect(Collectors.toList());
		
		emails.forEach(System.out::println);
		
		//filter, map 같이 사용한다
		// 정의 : map - 연산을 하여 반환한다
		//		filter - 조건에 맞는 값을 찾는다
		// 시나리오 : 1) 가격이 10000이 넘는 차를 조회 
		//			2) 가격만을 추출하고
		//			3) 가격에 0.14를 곱하여 반환
		// 사용처 : 회사 보너스 처리
		System.out.println(	//메소드 입력 처리 방식 : function interface => Call Back 함수
				MockData.getCar()
				.stream()
				//1) 가격이 10000이 넘는 차를 조회
				.filter(car -> {
					System.out.println("filter Car" + car);
					return car.getPrice() > 10000;
				})
				//2) 가격만을 추출하고
				.map(car -> {
					System.out.println("mapping Car : " + car);
					return car.getPrice();
				})
				//3) 가격에 0.14를 곱하여 반환
				.map(price ->{
					System.out.println("mapping Car 0.14 :" + price);
					return price+ (price*.14);
				})
				//4) 리스트로 출력
				.collect(Collectors.toList())
				);
		
		
		
	}

}
