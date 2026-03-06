package com.min.edu.choice;

import com.min.edu.H2O;
import com.min.edu.sub.Ice;
import com.min.edu.sub.Steam;
import com.min.edu.sub.Water;

//TODO 004 다형성을 사용해서 "다르게 생성된 객체"를 반환시키고, "공통 메소드"를 실행시킨다
public class ChoiceFactory {
	
	//정의 : 다양한 반환객체가 있지만, 부모를 통해서(up-casting) 하나의 반환타입으로 작성이 가능
	/*
	 * 결론 : 객체는 입력된 값에 의해서 자동으로 인스턴스화 되고
	 * 		각 객체는 상위 부모의 클래스를 통해서 반환시킨(up-casting)
	 * 		반환된 객체는 VMI에 의해서 공통 메소드로 실행시킴
	 */
	public H2O factory(int choice) {
		H2O item = null;
		switch (choice) {
		case 1: item = new Steam(); break;
		case 2: item = new Water(); break;
		case 3: item = new Ice(); break;

		}
		
		return item;
	}

}
