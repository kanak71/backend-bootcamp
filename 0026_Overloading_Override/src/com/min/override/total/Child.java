package com.min.override.total;

public class Child extends Parent {

	@Override
	public void parentMake() {
		//super.parentMake();
		System.out.println("난 부모를 재정의했다");
		
	}
	
	public void callParent() {
		
	}
	
	

}
