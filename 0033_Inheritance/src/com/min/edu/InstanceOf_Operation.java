package com.min.edu;

//TODO 003 
/*
 * 정의 : 안전 예방책 instanceOf 연산자를 사용하여 특정 객체로 캐스팅 할 수 있는지 여부를
 * 		"런타임" 중에 테스트 할 수 있다
 * 결론 : 이 연산자는 예외를 일으키지 않고 왼쪽 객체를 오른쪽 유형으로 캐스팅 할 수 있는 경우 true
 */
public class InstanceOf_Operation {
	public static void main(String[] args) {
		//instanceOf를 통한 객체의 형변환 가능 여부 확인
		Apple a = new Apple();	//1) 자식의 이름으로 객체를 생성
		Fruit f = a;	//2) 부모의 타입으로 자식을 참조한다
		
		//f의 원래 생성되어 있던 타입을 알 수 없다. 그래서 down-casting하기 전에 확인 작업
		if(f instanceof Banana) {
			System.out.println("f는 바나나가 될 수 있다");
		}
		
		if(f instanceof Apple) {
			Apple myApple = (Apple)f;
			System.out.println("f는 사과가 될 수 있다");
			
		}
		
		if(f instanceof Apple apple) {
			System.out.println("f는 사과로 될 수 있다" + apple);
		}
		
		if(!(f instanceof Banana)) {
			System.out.println("f는 바나나가 될 수 없다");
		}
		
	}
	
	

}
