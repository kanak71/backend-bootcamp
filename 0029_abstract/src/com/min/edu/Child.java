package com.min.edu;


//TODO 003 AParent에서 구현을 강요한 메소드를 강제 구현
public class Child extends AParent {

	@Override
	public void make() {
		System.out.println("부모인 IParent와 AParent에서 구현하지 않은 make를 구현");

	}

}
