package com.min.edu;

public class Constructor_Main {

	public static void main(String[] args) {
		//GeneralClass를 사용하기 위해서 메모리 올리는 작업
		//instance화 : new 클래스명();
		//GeneralClass(); GeneralClass에 있는 (default)생성자
		GeneralClass general = new GeneralClass();
		
		general.printMember();
		

	}

}
