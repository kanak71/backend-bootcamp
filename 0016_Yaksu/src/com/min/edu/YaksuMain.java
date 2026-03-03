package com.min.edu;

public class YaksuMain {

	public static void main(String[] args) {
		//default 생성자
		//클래스명과 같은 메소드
		//반환타입이 없고
		//클래스를 만들면 암묵적으로 자동으로 생성되어 있다
		//new룰 통해서 인스턴스화 할 때 사용되고 주소를 반환하는 메소드
		
		Yaksu yaksu = new Yaksu();	
		yaksu.yaksu_sum(10);
		
		System.out.println();
		
		Perfect perfect = new Perfect();
		perfect.perfectNum(1000);
		
		Friendly friend = new Friendly();
		friend.friendlyNum(10000);
		

	}

}
