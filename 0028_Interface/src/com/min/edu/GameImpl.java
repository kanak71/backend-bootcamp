package com.min.edu;

public class GameImpl implements IGame{

	@Override
	public void printConf() {
		System.out.println("내가 구현했다 printConf");
		
	}

	@Override
	public void play() {
		System.out.println("내가 구현했다 play");
		
	}

	@Override
	public String makeA() {
		System.out.println("내가 구현했다 makeA");
		return null;
	}

}
