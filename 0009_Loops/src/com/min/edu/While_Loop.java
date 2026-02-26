package com.min.edu;

public class While_Loop {
	public static void main(String args[]) {
		//while 루프는 지정된 조건이 true인 경우에만 코드블록({})을 통해서 실행되고 조건이 true 유지되는 동안 루프를 계속한다
		
		int x = 0;
		while(x < 5) {	//조건 : 첫번째 조건 판단
			System.out.println(x++);	// 선처리 후 증가
		}
		
		//do~while : 작동 방식은 같으나 먼저 한번 연산을 실행한 후 동작
		int y=0;
		do {
			System.out.println(y++);
		} while (y<5);
	}

}
