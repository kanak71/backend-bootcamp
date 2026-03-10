package com.min.edu;

public class LamdaExam_Variable {
	
	void method(int age) {
		int localValriable = 10;
		
		MyFunction f = () ->{
			System.out.println("age : " + age);
			System.out.println("localVariable :" + localValriable);
			
		};
		
		f.method();
	}

}
