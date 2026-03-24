package com.min.edu;

import java.util.Scanner;

public class CoffeeOrder {
	
	/*
	 * TODO Builder Pattern
	 *  Builder 패턴은 복잡한 객체를 단계별로 구성하여 생성할 수 있도록 도와주는 디자인 패턴
	 *  생성자의 인자가(멤버필드의 개수) 너무 많아질 때 -> 가독성, 순서기억, 유지보수, 필요값만 선택적으로 입력하기 힘들다
	 *  순서 실수나 선택적인 옵션을 명확히 관리하기 어려울 때 이러한 문제를 해결하기 위해 Builder 패턴이 사용된다
	 */

	public static void main(String[] args) {
		// 1) 기본적인 주문을 했을 경우
		
		// 2) 시럽과 크림을 추가 주문 했을 경우
		
		// 3) 크림만 주문 했을 경우
		
		Scanner scan = new Scanner(System.in);
		// 1. 필수정보 입력
		System.out.println("커피 이름을 입력하세요");
		String name = scan.nextLine();
		
		System.out.println("물 양을 입력헤 주세요");
		String water = scan.nextLine();
		
		// 2. Builder 생성
		Coffee.CoffeeBuilder builder = new Coffee.CoffeeBuilder(name, water);
		
		// 3. 옵션 선택
		System.out.println("시럽 추가? (true/false)");
		boolean sirup = scan.nextBoolean();
		builder.setSirup(sirup);
		
		System.out.println("크림 추가? (true/false)");
		boolean cream = scan.nextBoolean();
		builder.setCream(cream);
		
		// 4. 객체 생성 
		Coffee coffee = builder.build();
		
		// 5. 결과 출력
		System.out.println("주문한 커피가 나왔습니다 : " + coffee);
		
		scan.close();

	}

}
