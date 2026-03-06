package com.min.edu.shape;

import com.min.edu.comm.AreaImpl;
import com.min.edu.comm.IArea;
import com.min.edu.comm.ICircle;

//TODO 003 공통기능을 부모(AreaImpl)로부터 받고 원계산에 필요한 특수한 구조는 ICircle을 따로 implements 한다
public class Circle extends AreaImpl implements ICircle {

	@Override
	public void cal(int x, int y) {
		super.x = x;
		super.y = y;
		result = x*y*IArea.PI;

	}
	
	public void result(int x) {
		cal(x,x);
		
	}
}
