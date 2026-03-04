package com.min.edu.prac;

public class InfoMain {
	
	//정리 : 객체는 참조타입이다. 참조타입은 주소를 전달한다
	//문제점 : 주소를 가지고 있는 곳 이라면 모두 변경되고, 변경되는 객체는 사용되는 모든 곳에서 영향을 받는다
	//		공통으로 사용하는 객체는 반드시 Clone 되어야 한다
	
	public static void main(String args[]) {
		Info info = new Info();
		info.name="토마토";
		info.age=27;
		info.address="이탈리아";
		
		info.infoPrint();
		
		//결론 : 주소를 전달해서 다른 곳에서 값을 변경하면 : 모두 영향을 받는다
		ChangeInfo.InfoInput(info);
		info.infoPrint();
	}

}
