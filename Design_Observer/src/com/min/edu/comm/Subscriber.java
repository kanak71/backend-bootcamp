package com.min.edu.comm;

//TODO 001 감시자 인터페이스 '구독자들이 구현해야할 양식'
public interface Subscriber {
	
	void update(String message);	//알람을 받았을 때 실행할 메소드
	
	
	
}
