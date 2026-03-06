package com.mim.edu;

import com.mim.edu.util.ChoiceArea;
import com.min.edu.comm.AreaImpl;

public class AreaCalMain {

	
	//TODO 008 OCP구조의 확장가능한 시스템 설계 완료
	public static void main(String[] args) {
		AreaImpl obj = ChoiceArea.choiceShape();
		obj.cal(10, 20);
		obj.print();

	}

}
