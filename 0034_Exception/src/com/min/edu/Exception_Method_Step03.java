package com.min.edu;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO 003 
//			java.lang.Exception 클래스란?
//			예외처리의 상위쯤 되는 클래스
//			Throwable

/*
 * 주의점 : 예외처리 계층구조에 따라서 작성하면 된다
 * 		상위 catch에 상위 계층의 Exception Class를 입력하면 안된다
 */

public class Exception_Method_Step03 {
	
	public int calculation() {
		int n = 0;
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("정수를 입력해 주세요");
			n= scan.nextInt()/scan.nextInt();
			
			//상위에서 하위의 객체를 up-casting 해서 사용할 수 있다
		} catch (InputMismatchException e) {
			
			//catch : JVM 상황에 맞는 예외클래스를 new 해서 생성해 준다
			//		up-casting을 통해서 상위로 올려주면 되겠지
			//		Exception 모든 것들을 처리해준다
			System.out.println("입력 잘못 입력 했잖아");
			
		} catch (ArithmeticException e) {
			System.out.println("어떻게 나누기를 0으로 하니");
		}
		catch (Exception e) {
			System.out.println("예측하지 못했던 결과야" + e.toString());
			e.printStackTrace();	//제일 상세하게 위치, 코드
		}
		
		System.out.println("나누기의 결과 : " + n);	//실행되지 않는다
		
		return n;
	}

}
