package com.min.edu.shape;

import com.min.edu.comm.AreaImpl;

//TODO 006 삼각형 계산을 위한 클래스
public class Triangle extends AreaImpl {

	@Override
	public void cal(int x, int y) {
		super.x = x;
		super.y = y;
		super.result = x*y*0.5;

	}

}
