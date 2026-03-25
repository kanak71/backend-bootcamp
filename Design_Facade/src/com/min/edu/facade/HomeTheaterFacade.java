package com.min.edu.facade;

import com.min.edu.subsystem.Amplifier;
import com.min.edu.subsystem.DVDPlayer;
import com.min.edu.subsystem.Projector;

//TODO 005 파사드 클래스 복잡한 과정을 하나로 묶어주는 역할
public class HomeTheaterFacade {
	//객체를 입력받아 멤버필드에 넣어 줘야한다
	
	private Amplifier amp;
	private Projector projector;
	private DVDPlayer dvd;
	
	public HomeTheaterFacade(Amplifier amp, Projector projector, DVDPlayer dvd) {
		super();
		this.amp = amp;
		this.projector = projector;
		this.dvd = dvd;
	}
	
	//복잡한 과정을 "영화 감상"이라는 간단한 메소드로 기능을 통합한다
	public void watchMovie(String movie) {
		System.out.println("-- 영화를 준비중입니다 --");
		projector.on();
		projector.wideScreenMonde();
		amp.on();
		amp.setVolume(10);
		dvd.on();
		dvd.play(movie);
		System.out.println("-- 즐거운 감상되세요 --");
	}
	
	
	

}
