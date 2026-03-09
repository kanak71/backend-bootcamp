package com.min.edu.step01;

public class Generic_Step01_Main {

	//TODO 001 작성된 제네릭 클래스를 사용한 생성
	public static void main(String[] args) {
		//하나의 객체를 사용해서 다양한 타입의 멤버필드를 사용할 수 있다
		MyBox<String> name = new MyBox<String>();
		MyBox<Integer> age = new MyBox<Integer>();
		
		name.str = "동그라미";
		//name.str = 200;	//객체를 생성할 때 Generic을 String으로 선언했기 때문에 생성된 객체넌 String으로 값을 처리 할 수 있다.
		age.str = 100;
		
		System.out.printf("이름은 %s이고 나이는 %d 입니다\n", name.str, age.str);
		
		MyBox<Integer> iBox = new MyBox<>();	//입력은 마음대로, 출력 Integer
		iBox.str = 5;
		System.out.println(iBox.str);
	}

}
