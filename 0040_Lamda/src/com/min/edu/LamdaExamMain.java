package com.min.edu;

public class LamdaExamMain {

	public static void main(String[] args) {
		
		//외부클래스 생성, 내부클래스 생성
		LamdaExam_Inner outer = new LamdaExam_Inner();
		LamdaExam_Inner.Inner inner = outer.new Inner();
		inner.method();
		
		System.out.println("-----------------------------------------");
		
		LamdaExam_Variable variable = new LamdaExam_Variable();
		variable.method(30);
		
		

	}

}
