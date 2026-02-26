package com.min.prac;

public class StudentMain {
	
	public static void main(String args[]) {
		RollBook myName = new RollBook();
		Student callName = myName.call();
		
		System.out.println(callName.name);
		System.out.println(callName.age);
		System.out.println(callName.address);
		
	}

}
