package com.min.edu.comm;


//TODO 002 면적 계산은 각각의 면적계산법이 있기 때문에 자식클래스에게 위임(abstract)로 선언
//			값을 받기 위해서 x y 하는 변수로 모두 가지고 있다
//			그렇다면 자식이 가지고 부모가 미리 가지고 있어서 공통으로 사용한다
public abstract class AreaImpl implements IArea {
	
	protected int x;
	protected int y;
	
	protected double result;

	@Override
	public abstract void cal(int x, int y);
	
	@Override
	public void print() {
		System.out.printf("%d와 %d의 면적 결과는 %f\n", x, y, result);

	}

}
