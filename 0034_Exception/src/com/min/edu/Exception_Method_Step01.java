package com.min.edu;

import java.util.Scanner;

//TODO 001 예외상황이 발생하면 시스템은 멈춤
//			문제점? 분모 0일때, 나누기는 0으로 나누면 안됨
//				InputMisMatchException, ArithmaticException
public class Exception_Method_Step01 {
	
	public int calculation() {
		int n = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력해 주세요");
		n= scan.nextInt()/scan.nextInt();
		
		System.out.println("나누기의 결과 : " + n);	//실행되지 않는다
		
		return n;
	}

}
