package com.min.coffee.print;

import com.min.coffee.Coffee;

/**
 * 최종적으로 사용자에게 보여줄 출력
 * @author 82108
 * @since 2026. 03. 09
 */
public class CoffeePrint {

	/**
	 * 완성된 커피 클래스를 입력받아 출력해주는 메소드
	 * @param coffee 주문이 완료된 커피 정보
	 */
	public static void print(Coffee coffee) {
		System.out.println("--".repeat(20));
		System.out.println(coffee.getCoffeeName());
		System.out.println("가격 : " + coffee.getPrice() );
		System.out.println("--".repeat(20));
		System.out.printf("잔돈 : %d \t 커피 : %d잔 \n", coffee.getPay(), coffee.getCup());
		
	}
}
