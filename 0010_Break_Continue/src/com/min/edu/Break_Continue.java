package com.min.edu;

public class Break_Continue {

	//TODO 001
	//Loop에서 사용할 수 있는 두 가지 특수 키워드
	//상황 : 강제로 loop 종료, 특정한 조건일 때 연산은 건너뛰고 처음으로 실행하고 싶을 때
	public static void main(String[] args) {
		
		int n = 0;
		while(true) {//무한루프로 계속해서 while문의 연산을 실행, 전:(n<5)
			System.out.println(n++);//선처리 후증가: 0 출력이 되고 +1이 나감
			if(n == 5) {	
				break;
			}
			
		}
		
		for(int i=0; i< 10; i++) {	
			if(i==5) {
				break;
			}
			if(i==3) {
				continue;
			}
			System.out.println(i);
		}
		

	}

}
