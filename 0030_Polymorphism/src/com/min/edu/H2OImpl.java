package com.min.edu;

//TODO 002 H2O를 강제 구현하는 abstract 클래스
//정의 : interface와 abstract의 차이점
//문제 : abstract를 모두 다 abstract 메소드로 하면 interface와 같지 않을까?
//결론 : 기능적으로 같지만 생성자의 문제가
//		여러개의 interface를 사용할 수 있지만 하나의 부모가 되기 때문에 문법의 오류가 발생하게 된다
public abstract class H2OImpl implements H2O {

	@Override
	public abstract void print();

	@Override
	public abstract void make();
}
