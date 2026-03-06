package com.min.edu.shape;

import com.min.edu.comm.AreaImpl;


//TODO 005 사각형 계산을 위한 클래스
public class Square extends AreaImpl {

	@Override
	public void cal(int x, int y) {
		super.x = x;
		super.y = y;
		result = x*y;

	}

}
