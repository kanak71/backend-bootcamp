package com.min.edu;

/*
 * 정리 : 생성자는 클래스에 암묵적으로 자동으로 생성되거나 defualt 생성자
 * 		생성자를 재정의(Oveloading)을 할 수 있다
 * 결론 : 생성자에서 다른 오버로딩된 생성자를 호출 할 때 메소드명이 아닌 this()
 * 
 * 정리 : 클래스 내에서 부모와 나의 멤버를 구분하는 예약어
 * 결론 : 내 멤버는 모두 this
 * 		부모의 멤버는 모두 super
 */
public class Child extends Parent {
	
	public int num;
	
	//Child 클래스의 목적은 반드시 num이라고 하는 멤버필드에 값을 입력하고 객체를 생성하고싶다
	//로또 만들때
	public Child() {
		this(7);
	}
	
	public Child(int num) {
		//super();	//오류남 -> 부모가 생성자가 Overloading 되면서 default 생성자가 사라짐
		super(num+100);
		this.num = num;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();	//자식에서 부모를 호출
		System.out.println("Parent를 super예약어를 통해 멤버필드 호출 : " + super.num);
		System.out.println("child의 멤버필드 : " + this.num);
	}
	
	

}
