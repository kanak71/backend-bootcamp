package com.min.edu;

//TODO 003 비트연산자
public class Bitwise_Operation {
	
	//and or
	//민기 && || : short circuit
	// true & true => true
	// true & false => false
	// true | false => true
	
	public void bit() {
		byte b = 5&4;
		System.out.println("5&4의 결과 : " + b);	//4 -> 101 && 100(이진수)
		
		b = 5 | 4; //5 -> 101 | 100 = 101
		
		System.out.println("5|4의 결과 : " + b);
		
	}

}
