package com.min.edu;

import java.util.Scanner;

//TODO 005 final block : 정상과 예외 모두 실행되는 코드
//		게임을 ID로 접속 -> FPS -> 게임 하고 종료
//					-> FPS -> 예외가 발생했어
//							-> 게임이 종료
public class Exception_Method_Step05 {
	
	public int calculation() {
		int n = 0;
		
		try {	//정상실행 코드
			Scanner scan = new Scanner(System.in);
			System.out.println("정수를 입력해 주세요");
			n= scan.nextInt()/scan.nextInt();
			
			
		} catch (Exception e) {
			//예외가 발생했을때만 실행되는 코드
			System.out.println(e.toString());
		} finally {
			//정상과 예외 모두 실행되는 코드
			System.out.println("난 Exception이 발생 했을때만 실행된다");
		}
		
		System.out.println("나누기의 결과 : " + n);	//실행되지 않는다
		
		return n;
	}

}
