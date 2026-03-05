package com.min.edu;

/**
 * 기능만 선언되어 있고<br>
 * 자식 클래스에서 강제 구현을 요청하는 클래스
 */
public interface IGame_Bin {
	
	/*
	 * public으로 선언된 메소드
	 */
	public void printConf();
	/**
	 * default 접근제한자로 선언된 메소드
	 */
	void play();
}
