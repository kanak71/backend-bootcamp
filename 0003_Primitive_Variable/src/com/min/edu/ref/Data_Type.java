package com.min.edu.ref;

import java.util.ArrayList;

//TODO 001 선언과 타입의 종류
public class Data_Type {
	
	
	//TODO 002 선언과 대입
	public void declaring_assignment() { //함수 function method
		int val;	//선언, 사용되는 변수명 담기는 타입을 선언
		val = 10;	//선언(declaring) 변수의 값을 대입(assignment)
		
		int value = 10;	//선언과 대입을 한줄에 사용한다
		
	}
	
	
	//TODO 003 타입의 종류
	public void dataTypeKind() {
		// 리터럴(literal) => 숫자 기본 크기가 int 가지고 있다 : 컴퓨터가 번역하지 않고 입력 될 수 있는  값
		// byte b=1; 0 0 0 0 0 0 0 1
		// 정수형 : byte, short, int, long
		
		// 실수의 구성 - 정수부와 실수부로 나눠져 있다	1.1 12231231.0, 0.1231232 : 부동소수점
		// 실수형 : float, double
		// 문자형 : '' char
		// 논리형 : boolean - 자바에서는 예약으로 가지고 있다
		//		true, false = 1 0
	}
	
	
	//TODO 004 정수 타입
	public void integerType() {
		byte b = 2;
		short s = 2;
		int i = 2;
		long l = 2;
		
		//리터럴 표기법
		int myHex = 0xF; //hexadecimal(16진수)
		int myOct = 07;	//Octal(8진수)
		int myBi = 0b10; //Binary(2진수)
		
		// 숫자를 작성할 때 액수를 표기 할 때 1,000,000 문자 , , 가 문자형이기 때문에
		int bigNumber = 1_000_000;
	}
	
	
	//TODO 005 실수타입(부동소수점)
	public void floatType() {
		double myDouble = 3.14;
		double myDouble_2 = 3e2;	//지수표기법 3*10^2 = 300
		
		// 실수타입의 기본 크기는 double 크기로 유지 된다
		// 벤티 -> 톨 사이즈로 변경하려면 값을 버려야 한다
		// 1) 값이 float의 리터럴임을 선언하지 위해서 F 접두어를 사용해야 한다
		// 2) 명시적 casting을 선언 해줘야 한다
		float myFloat = 3.14F;
		float myFloat2 = (float)3.14;	//명시적 Casting
		
	}
	
	
	//TODO 006 문자형 타입(Unucode Character)
	public void charType() {
		//문자형의 선언 '(single quote)를 통해서 값을 구분 한다
		char myChar1 = 'A';
		//모든 문자형은 unicode 표현식인 16진수로 표기가 가능하다
		char myChar2 = '\u0000';
	}

	
	//TODO 007 논리형 타입(true, false 키워드로 값을 가지고 있다) - 절대 정수값을 변경이 불가능하다
	public void booleantype() {
		boolean myBool1 = true;
		boolean myBOOl2 = false;
	}
	
	
	//TODO 008 java 10부터 나오는 로컬변수 선언 방법
	/*
	 * var 타입
	 * java 10부터 로컬 변수는 var로 선언하여 컴파일러가 할당에 따라서 변수 유형을 자동으로 결정하도록 할 수 있다.
	 */
	
	public void varType() {
		// 동적타입 변수
		// 왼쪽에 있는 선언된 타입에 따라서 값이 정해짐
		// var 타입은 오른쪽에 선언되어 있는 값에 따라서 타입이 정해짐
		var i1 = 5; // Implicit Type
		int i2 = 5; // Explicit Type
		
		// 할당에서 변수의 유형이 분명한 경우는 선언을 줄이고 가독성을 높이기 위해서  var를 사용하는 것이 좋다
		ArrayList list = new ArrayList();
		var ii = new ArrayList();
	}
	
	/*
	 * 얕은 복사 vs 깊은 복사
	 * 기본 타입은 모두 깊은 복사(값전달)
	 * 
	 */
}
