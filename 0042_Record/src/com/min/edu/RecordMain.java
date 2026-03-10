package com.min.edu;

public class RecordMain {

	public static void main(String[] args) {
		Student_Record stu = new Student_Record("왕눈이", 12);
		System.out.println(stu); //toString 자동 생성됨
		
		System.out.println(stu.age());
		System.out.println(stu.name());
		
		Student_Record stu01 = new Student_Record("왕눈이", 12);
		System.out.println(stu.equals(stu01));	//객체 안의 값이 같다면 같다. 객체를 hashcode&equals 오버라이딩을 했다

	}

}
