package com.min.edu.main;

import com.min.edu.facade.HomeTheaterFacade;
import com.min.edu.subsystem.Amplifier;
import com.min.edu.subsystem.DVDPlayer;
import com.min.edu.subsystem.Projector;

/*
 * TODO 001 파사드 패턴이란?
 * 	- 건물의 정면(외관), 복잡한 내부 구조를 가리고 외부를 보여주는 겉모습 OCP
 *  - 쉽게 사용할 수 있도록 하나의 통합된 창구(interface)
 *  - 낮은 결합도 :
 *    가독성 향상 :
 *    계층 구조 형성 : 
 *    
 */
public class FacadeMain {

	public static void main(String[] args) {
		Amplifier amp = new Amplifier();
		Projector projector = new Projector();
		DVDPlayer dvd = new DVDPlayer();
		
		//파사드 생성
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amp, projector, dvd);
		
		// *** 단 한줄로 복잡한 작업을 수행
		homeTheaterFacade.watchMovie("인터스텔라");

	}

}
