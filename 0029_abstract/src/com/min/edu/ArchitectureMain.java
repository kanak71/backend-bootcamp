package com.min.edu;

public class ArchitectureMain {

	public static void main(String[] args) {
		//TODO 005 자식의 이름으로 자식을 생성 => 모두사용가능하다
		Child c = new Child();
		c.make();	//Child
		c.print();	//AParent로 부터 물려 받은 것
		
		//TODO 006 부모이름으로 자식을 참조(up-casting)
		// 메모리 특징 마지막
		//		: 공개되어 있는 메소드만이 사용가능하다
		//		  타입에 따라서 사용되는 멤버가 정해진다
		IParent p = c;	//
		p.make();
		p.print();
		

	}

}
