package com.min.edu;

import java.util.Iterator;

//TODO for문 연습 : for문의 local 변수를 값으로 사용하는 방법
//				  for문의 반복을 제어하는 방법

public class Triangle {
	
	/**
	 * 첫번째 삼각형 그림
	 * @param n 생성되는 층수
	 */
	
	public void one(int n) { 
		for(int i=0; i<n; i++) { //0부터 n까지 반복하겠다
			for(int j=0; j<i+1; j++) { //i를 변하는 값으로 사용
				System.out.print("■");
			}
			System.out.println(); //j for문 완료 후 다음 줄로 이동
		}
		
	}
	
	/**
	 * 두번째 그림 출력
	 * @param n 층수
	 */
	
	public void two(int n) { 
		for(int i=0; i<n; i++) { //0부터 n까지 반복하겠다
			for(int j=0; j<n-i; j++) { //i를 변하는 값으로 사용
				System.out.print("■");
			}
			System.out.println(); //j for문 완료 후 다음 줄로 이동
		}
		
	}
	
	/**
	 * 세번째 그림 출력<br>
	 * 두번재 그림과 첫번째 그림 for문을 합쳐서 작성함
	 * @param n 입력되는 층 수
	 */
	
	public void three(int n) {
		for(int i=0; i<n; i++ ) {
			
			for(int j=0; j<n-i-1; j++) {
				System.out.print("■");
			}
			
			for(int j=0; j<i+1; j++) {
				System.out.print("□");	
			}
			System.out.println();
		}
	}
	
	public void four(int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("□");
			}
			for(int j=0; j<5-i; j++) {
				System.out.print("■");
			}
			System.out.println();
		}
	}
	
	

}
