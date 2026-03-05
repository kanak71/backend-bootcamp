package com.min.edu;

/*
 * 질문 : extends 예약어는 무엇을 뜻하나요?
 * 		확장, 상속받는다, 클래스의 확장, 이어받는다, 부모클래스를 자식이 확장, 물려받는다
 * 		A extends B
 * 		-> B를 부모클래스로 사용하겠다. 상속관계를 만들어 낼 때 사용
 * 		ㄴ 부모의 멤버를 확장
 * 		ㄴ 부모의 멤버를 이어받아서 오버라이드를 할 수 있다
 * 		ㄴ 부모가 선언한 메소드를 내가 만들지 않아도 사용할 수 있다
 * 
 * 결론 : extends는 부모와 자식 클래스를 만들어내는 예약어이다
 * 
 * 확인해볼 사항 : 
 * 		확장(상속) - extends, implements
 * 		같은 클래스의 형태라면 extends
 * 		다른 형태라면 implements
 * 		일반클래스 A, 일반클래스 B = A extends B
 * 		일반클래스 A, 인터페이스 C = A implement C
 * 		인터페이스 D, 인터페이스 C = D extends C
 */

//정의 : IGame은 두개의 interface를 확장하고 있다
//		IGame은 IGame_Conf와 IGame_Bin을 반드시 구현해야 한다
public interface IGame extends IGame_Conf, IGame_Bin {
	
	public int age = 100;
	String name = "쿼카";
	
	public String makeA();
	
	//interface에서 가장 중요한 역할을 하는 default 메소드입니다
	//결론 : 공통메소드를 정의할 때 사용
	default void print(String s) {
		System.out.println("interface 메소드 :" +s);
		
	}
	
	//정적 인터페이스 메소드
	static int sum(int n) {
		return n+10;
	}
	
	//interface 내부에서 연산을 위해서 추가적으로 작성 가능한 영역
	private static String getString() {
		return "String";
	}
	
	default void printString() {
		System.out.println("interface private 메소드 호출" + getString());
	}
	
	//클래스명과 java파일의 명이 같아야한다
	//java파일의 명과 다르게 내부에서 보이지않는 클래스를 만들어서 숨김
	class HelperClass{
		public void helperMethod() {
			System.out.println("innerClass");
			
		}
	}
	
	
	
	
	
	
}
