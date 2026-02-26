package com.min.edu;

public class For_Loop {
	
	//TODO 001 for문
	public static void main(String[] args) {
		//반복문 : 초기값 조건 증감이 있는 반복문이다
		
		//0부터 5미만까지의 숫자를 출력해주세요
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			
		}	//etc누적, 최종 i값이 필요하다면 어떻게 될까요?
		//변수의 scope local variable
		
		//for(초기값; 조건; 증감) { 연산 } 초기값 -> 조건 -> 연산 -> 증감
		
		int i=0;
		for(; i<args.length; i++) {
			System.out.println(":-D " + i);// 0 1 2 3 4
		}
		System.out.println("최종 i값 : " + i);
		
		//누적변수 0부터 5 미만의 값들을 더하면 값은 무엇인가요? 0 1 2 3 4
		int sum = 0;
		for(int j=0; j>5; j++) {	// 0 1 2 3 4
			sum = sum + j;	//sum += j
		}
		System.out.println("최종적으로 5까지 누적된 합의 결과 :" + sum);
		
		//숫자 10의 약수의 합을 구하겠다(10제외하고 합 : 진약수합)

		int initValue = 10;
		int sumResult = 0;
		for(int j=1; j < 10; j++) {
			if(initValue % j == 0) {
				sumResult += j;
			}
		}
		System.out.println("10의 진약수의 합 : " + sumResult);
		
		
		
		// 향상된 for문 : 배열 기본타입 배열 / 참조타입 배열
		int n = 1; int m = 2; int o =3;	// -> 번거로움
		
		int a=1, b=2, c=3;	//-> 조금 더 나음
		
		//변수가 많아서 사용할 때 어떻게 기억을 하나??
		//하나의 통에다가 넣음 되잖아 =>POJO의 문법은 class를 만들어서 값을 모으면, 객체명으로 하면 되겠네
		int[] array = {1,2,3,4};	//array라는 이름, index를 통해서 구분한다 array[0] => 1
		
		for(int j=0; j<array.length; j++) {	//숫자는 1부터 시작, 하지만 인덱스는 0부터 시작 = length는 배열의 크기 4를 가진다, 하지만 마지막  index는 3이다
			System.out.println("array 내부 값 : " + i+ ":" + array[j]);
		}
		
		//어차피 다 출력할거라면 굳이 index가 필요한가? 내부에 있는거 처음부터 다 출력하면 돼 : 향상된 for문
		for (int j : array) {
			System.out.println("향상된 for 문의 출력 : " + j);
			
		}
		
		
		

	}

}
