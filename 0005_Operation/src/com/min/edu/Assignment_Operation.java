package com.min.edu;

//TODO 002 대입연산자
public class Assignment_Operation {
	
	/*
	 * 단축연산자
	 */
	
	//연산자는 반드시 왼쪽에 있어야 한다
	public void assignment() {
		//일반적인 대입연산자
		int i = 10;
		
		i = i+5;	//변수를 두 번 쓰려니 가독성이 떨어지네
		i += 5;		//간단
		
		i =+5; 	//5 -> +양수의 의미를 갖는다 
		
	}
	
	//증감연산자
	public void assignment_in_degreement() {
		//선증가 후처리, 선처리 후증가
		int y = 100;
		System.out.println(++y); //100 -> 101 -> 출력
		System.out.println(--y); //101 -> 100 -> 출력
		System.out.println(++y); //100 -> 101 -> 출력
		System.out.println(y++); //101 -> 출력 -> 102
		System.out.println(y--); //102 -> 출력 -> 101
		System.out.println(y);
		
		int i=0;
		for(; i < 5; i++) {
			//0 1 2 3 4
			System.out.println(i);
		}
		//5
		System.out.println(i);

	}

}
