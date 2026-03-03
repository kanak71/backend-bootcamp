package com.min.edu.dto;

public class InfoMain {
	
	public static void main(String args[]) {
		//new를 통해서 같은 값을 가지고 있는 객체를 선언해본다
		
		//멤버필드는 선언만 되어있다면 각 타입으로 instance화 할 때 초기화된다
		//String name = null, int age = 0;로 자동 초기화 됨
		InfoDto dto01 = new InfoDto();
		InfoDto dto02 = new InfoDto();
		
		dto01.setName("둘리");
		dto01.setAge(40);
		dto01.setAddress("성북구");
		
		dto02.setName("둘리");
		dto02.setAge(40);
		dto02.setAddress("성북구");
		
		//증명
		//TODO 400 같은 주소인가요?
		//		InfoDto의 객체를 오버라이딩 해도 주소는 다릅니다
		System.out.println("참조타입을 == 으로 비교하면 주소 비교이다 : " + (dto01==dto02));	//false
		
		//TODO 401 같은 hashcode 인가요? 아니요 서로 new를 통해 생성하면 새로운 hashcode를 부여 받습니다
		System.out.println("dto01의 hashcode :" + dto01.hashCode());	//321001045
		System.out.println("dto02의 hashcode :" + dto01.hashCode());	//321001045
		
		//TODO 402 메모리(system)의 identityHashcode를 출력해보면?? 오버되있지 않기 때문에 hashcode와 같은 값이 출력
		System.out.println("dto01의 identityHashcode :" + System.identityHashCode(dto01));	//321001045
		System.out.println("dto02의 identityHashcode :" + System.identityHashCode(dto02));	//791452441
		
		//TODO 403 결론 : hashcode는 자동으로 부여된다. 하지만 hashcode를 안의 값으로 오버라이드 했다면 
		//										 값이 같으면 같은 hashcode를 가질 수 있도록 비교 할 수 있다
		// hashcode를 계속해서 사용하면 코드가 길어짐
		// equals() 메소드를 hashcode로 비교 할 수 있다
		// 객체는 같은 객체로 판단한다면 equals를 통해서 비교하라
		//		=> 같은 객체의 뜻은, 같은 값을 가지고 있는 동일한 곳에서 생성된(타입) 객체를 비교하는 것
		System.out.println("dto01과 dto02를 (안의 값) 비교 : " + dto01.equals(dto02));
		
		
		
		
	}

}
