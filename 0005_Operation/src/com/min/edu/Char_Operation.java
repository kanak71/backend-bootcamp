package com.min.edu;

//TODO 004 char 연산
public class Char_Operation {
	
	/*
	 * char는 3개의 리터럴 값을 가지고 있다
	 *  unicode 표를 따라간다 => 'A' => 숫자 65이다, 'B' => 숫자 66이다
	 *  16진수 : '\0041'
	 */
	
	public void charLiteral() {
		char c1 = 'A';	//char의 리터럴은 ''
		char c2 = 65;	//char의 리터럴은 숫자 표의 위치
		
		System.out.println(c1);
		System.out.println(c2);
		
		//char의 정수 연산이 진행될 경우 자동으로 리터럴의 값은 정수 변경된다
		//자바에서 연산의 기본은 정수연산(int)
		
		System.out.println(c1 + 1);	//66 => 정수연산
		
		int i1 = c1+1;	//정수연산 'A' -> 65 + 1 => 66
		char result = (char)i1;
		
		System.out.println(result);	//B
		
		
	}
	

}
