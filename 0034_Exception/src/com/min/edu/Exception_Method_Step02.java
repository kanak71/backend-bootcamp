package com.min.edu;

import java.util.Scanner;

//TODO 002 Step01의 소스를 예외처리 하여 마지막의 실행이 문제가 발생한다면 예외처리를 해서 코드를 발생시켜보자
public class Exception_Method_Step02 {
	
	public int calculation() {
		int n = 0;
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("정수를 입력해 주세요");
			n= scan.nextInt()/scan.nextInt();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.toString());
		}
		
		System.out.println("나누기의 결과 : " + n);	//실행되지 않는다
		
		return n;
	}

}
