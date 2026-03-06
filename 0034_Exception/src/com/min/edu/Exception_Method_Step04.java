package com.min.edu;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO 004 multi-catch 블럭을 작성하는
//			예측되는 것들을 catch block을 작성해서 
//주의할 사항 : 같은 계층의 예외는 사용이 가능한데, 상위 계층은 사용하지 못해요
//			개발할 때 명확하게 예외상황이 분석되어야 한다

public class Exception_Method_Step04 {
	
	public int calculation() {
		int n = 0;
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("정수를 입력해 주세요");
			n= scan.nextInt()/scan.nextInt();
			
		} catch (InputMismatchException | ArithmeticException e) {    // | Exception e) {
//			e.printStackTrace();
			System.out.println(e.toString());
		}
		
		System.out.println("나누기의 결과 : " + n);	//실행되지 않는다
		
		return n;
	}

}
