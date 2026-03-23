package com.min.edu;

/*
 * SingleFactory를 메모리에 한번만 생성할 수 있도록 작성
 * 사용처 : DB커넥션 관리, 설정관리, 로그, Spring Framework의 Bean
 */
public class SingleFactory {
	
	//1) 현재 클래스의 주소를 담을 수 있는 멤버필드를 작성 => 타입이 현재클래스인 멤버필드 작성
	private static SingleFactory single;

	//2) default 생성자를 외부에서 접근 못하도록 private 선언
	private SingleFactory() {
	}
	
	//3) 외부에서 현재 클래스의 객체를 null인지 판별하는 메소드 필요 static 메소드 작성
	public static SingleFactory getInstance() {
		if(single == null) {
			single = new SingleFactory();
		}
		
		return single;
	}
}
