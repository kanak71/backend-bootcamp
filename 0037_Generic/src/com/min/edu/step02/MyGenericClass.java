package com.min.edu.step02;

//TODO 002 제네릭을 사용하는 메소드 / 생성자 정의 및 사용
public class MyGenericClass {
	
	private String s;
	
	//입력받은 argument의 모든 값을 다 toString()을 통해서 문자열 변경해서 멤버필드에 입력
	public <T> MyGenericClass(T t) {
		s = toString().toString();
	}
	
	public static <T> void printArray(T[] array) {
		for (T t : array) {
			System.out.println(t);
		}
	}

	public String getS() {
		return s;
	}	//private이라 외부에서 값 가져갈라고 만듦
	
	
	

}
