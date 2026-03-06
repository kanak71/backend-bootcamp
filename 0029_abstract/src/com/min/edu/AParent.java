package com.min.edu;

//TODO 002 추상클래스 및 추상메소드

/*
 * 정의 : 클래스가 추상메소드를 포함하고 있다면 반드시 추상클래스가 되어야 한다
 * 키워드 : abstract
 * 결론 : 추상메소드는 메소드는 abstract 작성
 * 		추상클래스는 class에 abstract 작성
 * 주의사항 : class 내에 abstract 메소드가 있다면, 반드시 class에 abstract를 선언해줘야한다
 */
public abstract class AParent implements IParent{
	//부모가 interface이기 때문에 자식이 무조건 구현해야 한다

	@Override
	public abstract void make();

	@Override
	public void print() {
		System.out.println("난 IParent > AParent 강제 구현됨");
		
	}
	
	

}
