package com.mim.edu.util;

import java.util.Scanner;

import com.min.edu.comm.AreaImpl;
import com.min.edu.shape.Circle;
import com.min.edu.shape.Square;
import com.min.edu.shape.Triangle;

//TODO 007 분기위한 Factory 객체
public class ChoiceArea {
	
	//객체를 한번만 메모리에 생성되도록(new가 한번만 되도록 - reference와 hashcode가 한번만 만들어지고 재활용)
	//single-ton design pattern
	
	public static AreaImpl choiceShape() {
		AreaImpl obj = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("선택해주세요 1.삼각형, 2.원형, 3.사각형");
		int ch = scan.nextInt();
		
		switch (ch) {
		case 1: obj = new Triangle(); break;
		case 2: obj = new Circle(); break;
		case 3: obj = new Square(); break;

		}
		
		
		return obj;
	}

}
