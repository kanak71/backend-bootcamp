package com.mim.edu;

import java.util.Arrays;
import java.util.List;

public class CardMain {

	public static void main(String[] args) {
		
//		CardOne card01 = new CardOne();
//		CardOne card02 = new CardOne();
//		System.out.println("첫번째 객체 비교 : " + card01.equals(card02));	
		//hashcode 오버라이딩을 하면 true, 하지 않으면 false
		
//		System.out.println("출력 toString() :" + card01);	//VMI동작
		
//		for (int i = 0; i <10; i++) {
//			System.out.println(new CardOne());
//		}
		
		CardCase make = new CardCase();
		List<CardOne> cardcase = make.getCardcase();
		
		for (CardOne one : cardcase) {
			System.out.println(one);
		}
		
		//1. CardCase는 10장의 카드를 가지고 있다
		//2. 사용자는 3장의 카드를 CardCase로 부터 분배받는다
		//3. 결과적으로 사용자가 1명인 경우, 최종 카드케이스는 7장, 사용자 3장
		//사용자 카드를 만들자
		CardOne[] user1 = new CardOne[3];
		for (int i = 0; i < user1.length; i++) {
			user1[i] = cardcase.get(0);
			cardcase.remove(0);
		}
		System.out.println("user의 카드 : " + Arrays.toString(user1));
		System.out.println("나머지 카드 : " + make.getCardcase());
		
		

	}
}
