package com.min.edu.compare;

public class Concat {
	
	//TODO 200 Concatenation(연쇄) : 문자열의 + 연산
	//		많이 사용하시면 안됩ㄴ디ㅏ. 메모리에 너무 많이 생성되기 때문에 메모리가 부족할 수 있다
	//		StringBuffer와 StringBuilder를 사용해서 처리하는 코드가 많다
	//		정의 : 문자열과 만나면 보이는 그대로 문자열로 새로 생성된다
	public static void main(String args[]) {
		int a = 10;
		char c = 'A';
		boolean b = true;
		String str = "";	//아무것도 없는 값 null과는 다름
		
		//질문 : 연산자 중에서 가장 높은 우선순위는 ()
		
		//String tmp01 = a + c + b + str;	
		//오류가 발생, 연산은 앞에서 발생한다
		//a+c까진 가능. b를 연산할 때 타입이 다르기 때문에 오류가 난다
		
		String tmp02 = str + a + c + b;	//"" + 10 => "10" + "A" => "10A" = true =>"10Atrue"
		
		String tmp03 = str + (a+c) + b;	//10+'A' => 10+65 => 75 => "" + 75 => "75" + true => "68true"
		
	}

}
