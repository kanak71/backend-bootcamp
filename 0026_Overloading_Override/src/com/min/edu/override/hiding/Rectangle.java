package com.min.edu.override.hiding;

/*
 * TODO 001 부모로 사용될 클래스
 */
public class Rectangle {
	
	public int w =10, h=10;
	
	public static int newArea(int w, int h) {
		return w*h;
	}
	
	public void callMethod() {
		System.out.println("Rectangle 클래스");
	}

}
