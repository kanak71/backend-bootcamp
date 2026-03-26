package com.min.edu.mem;

import com.min.edu.comm.Subscriber;

//TODO 003 실질적으로 publisher를 구독하는 구독자
public class User implements Subscriber {
	
	private String name;
	
	public User(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println(name+"님 알림이 왔어요 : [" + message + "] 영상이 게시되었습니다" );

	}

}
