package com.min.edu;

public class Diamond_MathAPI {
	
	public void dia_math_api(int n) {
		
		for (int i = 0; i < n; i++) { //층수, 반복을 위한 for문
			System.out.print(Math.abs(i-n/2));	//i층번호, n/2 이전코드에서 mid로 만들 변수
			//abs -> 절댓값
			
			for (int j = 0; j < Math.abs(i-n/2); j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < n - 2*(Math.abs(i-n/2)); j++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}

}
