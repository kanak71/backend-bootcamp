package com.min.edu;

//TODO 001 Argument 입력받아서 값을 변화시키는 메소드를 가진 클래스
//			기본타입(int)을 받는 메소드, 참조타입(int[])을 받는 메소드
public class ValueChange {

	//오버로딩이다
	
	/**
	 * argument로 입력받은 n을 +100을 더하는 메소드
	 * @param n 정수
	 */
	public void change(int n) {
		n = n + 100;
	}
	
	/**
	 * argument로 참조타입인 int[]를 입력받아 0번 index에 100을 더하는 메소드
	 * @param n
	 */
	public void change(int[] n) {
		n[0] = n[0] + 100;
		
	}
	

}
