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

}
