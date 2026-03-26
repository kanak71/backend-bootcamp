package com.min.edu.subject;

import java.util.ArrayList;
import java.util.List;

import com.min.edu.comm.Subscriber;

//TODO 002 소식을 전하는 publisher : 영상을 업로드하면 구독자에게 알림을 보냄
public class YoutubeChannel {

	private List<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	//구독하기
	public void subscribe(Subscriber s) {
		subscribers.add(s);
	}
	
	//구독 취소하기
	public void unsubscribe(Subscriber s) {
		subscribers.remove(s);
	}
	
	//알림보내기 (모든 구독자의 update를 호출)
	public void notifysubscribe(String videoTitle) {
		for (Subscriber s : subscribers) {
			s.update(videoTitle);
		}
	}
	
	//영상업로드(상태 변환 발생)
	public void updateVideo(String title) {
		System.out.println("채널에" + title + "영상이 업로드 되었습니다");
		notifysubscribe(title);
	}
}
