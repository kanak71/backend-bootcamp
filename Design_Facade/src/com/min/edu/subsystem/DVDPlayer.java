package com.min.edu.subsystem;

//TODO 003 영화를 보기 위한 하위 시스템 DVD Player
public class DVDPlayer {
	
	public void on() {
		System.out.println("DVD 플레이어를 켭니다");
	}
	
	public void play(String movie) {
		System.out.println("영화 " + movie + "를 재생합니다");
	}

}
