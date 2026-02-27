package com.min.edu;

public class Diamond_Div {
	
	/**
	 * 묶음으로 increase와 decrease를 실행하는
	 * 위험(deligate)를 메소드를 만들자
	 */
	
	public void printProcess(int n) {
		this.printIncrease(n);
		this.printDecrease(n);
	}
	
	/**
	 * 피라미드 모양을 출력하는 메소드
	 * @param n 피라미드 층수
	 */
	private void printIncrease(int n) {	//test 값:3
		
		for (int i = 0; i < n; i++) {	//0 1 2
			//그림 빈칸
			for (int j = 0; j < n-i-1; j++) {
				System.out.print(" ");
			}
			//그림 별
			for (int j = 0; j < i*2+1; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}
	
	/**
	 * 역피라미드 출력
	 * @param n
	 */
	private void printDecrease(int n) {
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < 2*(n-i-1) +1; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
	}
}
