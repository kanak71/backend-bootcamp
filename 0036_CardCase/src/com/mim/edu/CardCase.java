package com.mim.edu;

import java.util.ArrayList;
import java.util.List;

//TODO 002 CardOne의 hashcode를 통해서 중복되지 않는 객체를 만듦
public class CardCase {
	
	private List<CardOne> cardcase;

	//멤버필드를 가져갈 수만 있는 getter 메소드
	public List<CardOne> getCardcase() {
		return cardcase;
	}

	
	public CardCase() {
		cardcase = new ArrayList<CardOne>();
		make();
	}
	
	private void make() {
		int n = 0;
		while(true) {
			CardOne card = new CardOne();
			if(!cardcase.contains(card))
				cardcase.add(card);
				n++; //index는 0부터, 길이와 크기는 1부터니깐
			
			if(n == CardOne.SHAPE.length * CardOne.NUMBER.length) {
				break;
			}
		}
	}

}
