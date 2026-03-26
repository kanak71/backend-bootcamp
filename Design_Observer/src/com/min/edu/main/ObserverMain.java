package com.min.edu.main;

import com.min.edu.mem.User;
import com.min.edu.subject.YoutubeChannel;

//TODO Observer를 통한 구독 서비스
public class ObserverMain {

	public static void main(String[] args) {
		YoutubeChannel channel = new YoutubeChannel();
		
		User user1 = new User("영희");
		User user2 = new User("철수");
		
		//구독을 등록(Event Listener)
		channel.subscribe(user1);
		channel.subscribe(user2);
		
		//이제 동영상을 업로드하면 자동으로 구독자에게 새로운 영상의 제목을 전송  알람
		channel.updateVideo("봄이면 꽃이 핀다");
		

	}

}
