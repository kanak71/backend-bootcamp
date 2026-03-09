package com.min.edu.step02;

import com.min.edu.step01.MyBox;

public class Generic_Step02_Main {

	public static void main(String[] args) {
		
		MyGenericClass o = new MyGenericClass(new MyBox<String>());
		System.out.println(o.getS());	//입력받은 아규먼트에 상관없이 무조건 문자열로 출력
		
		Integer[] array = {1,2,3};
		String[] strArray = {"집", "회사", "놀이터"};
		MyGenericClass.printArray(strArray);	//generic을 모르면 overloading 메소드를 작성해 줘야 한다

	}

}
