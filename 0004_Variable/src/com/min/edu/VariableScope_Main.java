package com.min.edu;

public class VariableScope_Main {

	//TODO local, instance, static 의 범위 실행 방법
	public static void main(String[] args) {
		
		// local 변수, 지역변수이기 때문에 method 외부에서 호출이 불가능하다
		//				ㄴ 반환타입이라는 코드를 작성해 사용한다
		
		VariableScope vs = new VariableScope();	//메모리에 할당됨, 사용할 수 있다
		vs.localVariable();	//()메소드
		
		//instance 변수는 생성된 객체를 통해서 접근하여 사용한다
		//멤버필드는 선언만 되어있다면 초기값 값을 입력해 놓는다
		//public int instanceVariable; 따라서 0의 값을 가지고 있다
		System.out.println(vs.instanceVariable);
		
		//VariableScope는 클래스 => 객체 : 값(memberfield) + 기능(method)
		//메모리에 할당 접근할 수 있다 => 객체명을 통해서 내부로 접근이 가능하다
		//객체명.필드명, 객체명.필드명()
		
		//객체가 생성되고 접근할 수 있는 주소를 가진 객체명만 있다면 재입력이 가능하다
		vs.instanceVariable = 777;
		System.out.println(vs.instanceVariable);
		
		//staitc 변수(전역이란 단어가 조금 그래서 자바에서는 사용을 잘 안함)
		//모든 곳에서 사용가능한 변수
		//객체를 생성하지 않는다
		//static application이 실행될 때 가장 먼저 메모리에 자동을 할당
		//static으로 선언된 것들은 주소를 가지고 있다. 객체를 생성할 필요가 없다
		System.out.println(VariableScope.staticVariable);


	}

}
