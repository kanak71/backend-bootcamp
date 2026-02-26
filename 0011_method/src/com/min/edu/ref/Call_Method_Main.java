package com.min.edu.ref;

public class Call_Method_Main {
	
	//TODO 002 사용하고자 하는 메소드를 (POJO클래스)를 사용(호출)하는 방법
	public static void main(String[] args) {
		
		/*
		 * 다른 클래스의 메소드를 호출하기 위해서는
		 * 호출하고자 하는 메소드가 포함된 클래스를 인스턴스화 해야한다
		 * 생성된 인스턴스를 통해서 메소드를 호출한다
		 * ## 인스턴스란? java의 소스파일(*.java)를 메모리(heap)에 할당하는 작업(new)
		 */
		
		Defined_Method dm = new Defined_Method();	//객체, 인스턴스화
		dm.method();
		
	}

}
