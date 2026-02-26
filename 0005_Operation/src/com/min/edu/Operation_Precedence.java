package com.min.edu;

//비트연산자의 우선순위

public class Operation_Precedence {
	public void operation() {
		boolean isc1 = 2+3 > 1*4 && 5/5 == 1;	//true
		//IDE 노란색 언더바 : 사용되고 있지 않은 변수를 나타냄
		
		//모든 연산의 최우선은 ()
		boolean isc2 = ((2+3) > (1*4)) && ((5/5) == 1);	//true
		
		
	}

}
