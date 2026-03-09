package com.min.edu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO 003 Set 인터페이스
//		정의 : 순서가 없고, 중복이 없다
//			같은 값이 입력되면, 원래 있었던 객체를 보존한다
public class Set_Feature {
	
	public void set_Array() {
		Set<String> sets = new HashSet<String>();
		String a = "가", b="나", c="다";
		
		sets.add(a);
		sets.add(b);
		sets.add(c);
		
		//set은 기준이 되는 key 혹은 index가 없기 때문에 객체로만 삭제 가능하다
		System.out.println(sets.remove("다"));	//true
		//set은 객체로만 판단이 된다	
		System.out.println(sets.contains("나"));	//true
		
		//출력은 기준(key, index)가 없기 때문에 향상된 for 문만 가능하다
		
		for(String str : sets) {
			System.out.println(str);
		}
		
		//변환 : idnex가 없기 때문에 사용하기는 좋은데 => 중복이 없는 값
		//		출력하기는 어렵다
		//Set => List로 변환
		List<String> setToList = new ArrayList<String>(sets);
		System.out.println(setToList);
		
	}
	
	public void set() {
		Set<String> sets = new HashSet<String>();
		String a ="가", b="나", c="다";
		
		String d = new String("다");
		
		System.out.println(System.identityHashCode(c));
		System.out.println(System.identityHashCode(d));
		
		sets.add(a);
		sets.add(b);
		sets.add(c);
		sets.add(d);
		
		//c와 d는 같은 값으로 인식한다. 따라서 3개이다
		System.out.println(sets.size());
		
		//c와 d중에 현재 sets에 들어가 있는 값은 누구일까?
		for(String s : sets) {
			System.out.println(System.identityHashCode(s));
			// -> c이다. 처음의 값을 유지중
		}
	}

}
