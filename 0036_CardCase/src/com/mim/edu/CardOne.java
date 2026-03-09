package com.mim.edu;

import java.util.Objects;

//TODO 001 모양과 숫자를 조합하여 한장의 카드를 만들어 내는 객체
public class CardOne {
	
	private String one;	//"
	
	public static final String[] SHAPE = {"♠","◆"};
	public static final String[] NUMBER = {"1","2","3","4","5"};
	
	//new를 했을 때 자동으로 그림 + 숫자 조합이 되는 멤버필드를 생성하기 위해서
	public CardOne() {
		int s = (int)(Math.random() * SHAPE.length);
		int n = (int)(Math.random() * NUMBER.length);
		one = SHAPE[s] + NUMBER[n];
	}


	//멤버필드의 접근제한자가 private이고, 외부에서 입력하지 못하도록 만들었기 때문에
	//생성된 one의 값만을 가져갈 수 있도록 만든 getter 메소드
	public String getOne() {
		return one;
	}
	

	//객체는 새로(new)만들면 reference와 hashcode가 부여된다
	//현재 객체를 비교하기 위해 "o2" -> o 2  => 각각을 비교하는 것이 너무 어렵고 복잡하다
	//안의 갑승ㄹ 객체의 hashcode다시 부여 한다
	//hashcode override

	@Override
	public int hashCode() {
		return Objects.hash(one);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardOne other = (CardOne) obj;
		return Objects.equals(one, other.one);
	}

//	//객체를 출력하면 Object의 toString()이 호출된다
//	//toString은 객체생성위치@16진수Hashcode 값
//	//부모의 toString Override하여 객체의 내부 값을 출력하도록 하겠다. VMI
	
	@Override
	public String toString() {
		return "CardOne [one=" + one + "]";
	}
	
	
	
	
	
	
	
	

}
