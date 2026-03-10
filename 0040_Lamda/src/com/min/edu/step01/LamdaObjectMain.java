package com.min.edu.step01;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class LamdaObjectMain {

	public static void main(String[] args) {
		//TODO 002 람다표현식의 사용
		/*
		 * 정의 : 인터페이스는 반드시 상속구조를 가지고 추상메소드를 오버라이드하여 기능을 부여
		 * 		어차피 구현을 해서 사용한다면 기능({})을 정의해서 바로 사용하자
		 * 결론 : 구현하지 않고 Function을 만들어서 입력하여 기능을 사용하자
		 * 
		 */
		ILamdaObject s = (x, y) -> x+y;
		int result = s.combie(2, 3);
		System.out.println(result);
		
		//TODO 003 공통기능 인터페이스 java.util.function 패키지에 정의 되어 있다
		//1) 정수더하기 
		BinaryOperator<Integer> adder = (x,y) -> x+y;
		int sum = adder.apply(3, 3);
		System.out.println("BinaryOperator 사용 : " + sum);
		
		//2) 실수처리
		//하나의 입력값(operand)를 받아서 같은 타입의 결과를 반환하는 함수형 인터페이스이다
		UnaryOperator<Integer> doubler = x -> x*2;
		int pow = doubler.apply(2);
		System.out.println("UnaryOperator" + pow);
		
		/*
		 * 결론 : 이전까지의 학습된 interface는 특정한 class에 implements하여 오버라이드 한 후 VMI를 통해서 사용했다
		 * 		하지만 function interface의 개념을 사용한다면, Lamda 표현식을 통해
		 * 		interface 함수의 {}(block)을 정의하여
		 * 		interface의 함수를 Lamda 표현식으로 사용할 수 있다
		 */

	}

}
