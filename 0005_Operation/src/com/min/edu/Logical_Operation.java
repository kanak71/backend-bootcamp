package com.min.edu;

//TODO 005 논리연산자
public class Logical_Operation {
	
	public void logical() {
		// & | !(부정연산자)
		
		//왜 개발을 할 때 | 하나를 사용하지 않고 || 두개씩 쓰는가
		//short circuit 라고 한다. 
		
		//한개로 되어있는 논리연산은 앞뒤의 상황에 상관 없이 모두 실행된다. 코드가 너무 많이 실행됨
		boolean isc1 = trueValue() & falseValue();	//false
		boolean isc2 = falseValue() & trueValue();	//false
		
		/*
		 * true가 앞에 나오지 않으면 어차피 false잖아 왜 뒤에를 연산해?
		 * 그냥 앞에 결과가 false이면 뒤에 하지 마
		 *  => short circuit
		 */
		
		System.out.println("-".repeat(30));
		boolean isc3 = trueValue() && falseValue();
		boolean isc4 = falseValue() && trueValue();	//falseValue만 실행한다

		
	}// logical 끝
	
	//내 클래스에서만 사용하는 반환타입이 있는 메소드를 만듦
	private boolean trueValue() {
		System.out.println("난 trueValue를 실행시킴");
		return true;
	}
	
	private boolean falseValue() {
		System.out.println("난 falseValue를 실행시킴");
		return false;
	}
	

}
