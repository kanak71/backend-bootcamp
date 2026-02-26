package com.min.edu;

//

public class Exam {
	
	public void charnumTointNum() {
		char c = '9';	
		
		//숫자 9로 출력하는 방법은?
		//int(c) => 코드는 문제 없지만 9는 나오지 않는다 -> 코드표에서 나오기 때문에 코드표의 숫자가 나옴
		
		char z = '0';
		int result01 = c-z;
		System.out.println(result01);
		
		//함수사용이 더 편하고 좋으니 함수를 알아두는 것도 좋아
		int result03 = Character.getNumericValue(c);
		System.out.println(result03);
		
	}
	
	public void charnumTointNum2() {
		// '9'-'0' => 연산은 정수연산이 우선이고, 참여하는 타입에 따라서 출력타입이 정해진다
		int n = '9';	//얘도 리터럴 이라는 말??????????
		int m = '0';
		
		int result = n-m;
		System.out.println("'9' - '0'의 결과 : " + result);	//concatnation 연쇄 :  몬자열과 만나면 모든 것들은 보이는 그대로 문자열
		//명시적 형변환
		System.out.println((char)result);
	}
	
	public void charToIntToChar() {
		//(char)('A'+2) => 'C'
		char A = 'A';
		char C = 'C';
		System.out.println((int)A);
		System.out.println((int)C);
		
		int n = 65+2;
		char nc = (char)n;
		System.out.println(nc);
		
		//for문은 Loof 연산, 반복한다
		//local variable, 증감연산자, 논리연산
		
		for (int i = 0; i < 100; i++) {	//0 1 2 3 .... 99 변수 i가 변하면서 실행이 된다
			System.out.println(i + "값 : " + (char)i);
			
		}
		
		
	}

}
