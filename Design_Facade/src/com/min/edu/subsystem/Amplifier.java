package com.min.edu.subsystem;

//TODO 002 영화를 보기 위한 하위 시스템 작성
public class Amplifier {
	
	public void on() {
		System.out.println("엠프를 켭니다");
	}
	
	public void setVolume(int level) {
		System.out.println("볼륨을 " + level + "로 설정합니다");
	}

}
