package com.min.edu;

//TODO 002 Student를 인스턴스화 하여 객체로 만들고 사용함
public class StudentMain {
	
	public static void main(String[] args) {
		Student st01 = new Student();	//인스턴스화 : 메모리에 할당해 주는 작업
		
		System.out.println(st01.name);
		System.out.println(st01.age);
		System.out.println(st01.address);
	}

}
