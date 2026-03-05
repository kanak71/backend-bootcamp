package com.min.edu;

public class Parent {
	
	public int num;

	public Parent(int num) {
		super();	//Object 생성
		this.num = num;
	}
	
	public void print() {
		System.out.println("Parent의 멤버필드 : " + this.num);
	}
	
	

}
