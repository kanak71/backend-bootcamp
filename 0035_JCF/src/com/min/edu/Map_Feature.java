package com.min.edu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * TODO 002 Map interface의 특징
 * 
 */

public class Map_Feature {
	/*
	 * 정의 : key와 value로 입력해야 한다
	 * 특징 : key는 중복이 되지 않는다
	 * 		중복된 key값을 입력하며 마지막에 입력한 value가 값으로 입력된다
	 * 주의점 : map은 key를 모르면 출력하기가 어렵다
	 * 사용 : 화면마다 출력하는 값이 다른 경우
	 */
	public void map_check() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("가", 10);
		map.put("나", 100);
		map.put("다", 1000);
		//순서대로 나오지는 않는다. JVM??에서 최적화된 순서로 알아서 출력해주기 때문
		
		System.out.println(map);
		
		map.put("다", 999);
		System.out.println(map);
		
	
	}
	
	public void map() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("가", 10);
		map.put("나", 20);
		map.put("다", 30);
		map.put("라", 40);
		map.put("마", 50);
		
		//출력은 key를 통해서만 value의 출력이 가능하다
		System.out.println(map.get("가"));	//10이라고 하면 아무것도 삭제되는게 없다 하지만 "가"라 하면 있다
		
		//삭제
		String rm = "마";
		Integer result = map.remove(rm);	//삭제 후 해당 key의 value 를 반환
		System.out.println("rm의 삭제 반환타입 : " + result);
		System.out.println("삭제 후 JCF map의 개수 : " + map.size());
		
		//명확하게 삭제 key와 value를 동시에 입력해줘야 한다
		boolean result1 = map.remove("라", 40);	//삭제 후 삭제 상태(boolean)를 반환
		System.out.println("삭제 결과 : " + result1);
		
		//확인 key와 value도 있기 때문에 key, value를 확인할 수 잇다
		System.out.println(map.containsKey("가"));	//true
		System.out.println(map.containsValue(40));	//flase 삭제해서 없다
		
		//출력
		//	정리 : key/value 구성이 되어 있고, key 모르면 출력이 어렵다
		//	결론 : key만 묶어서 가져온 후에, get(key)를 통해서 값을 출력
		//	추가 : 향상된 for문을 사용할 수도 있다 하지만 이해가 필요함
		
		
		// 1단계 : Map 객체의 key만을 가져온다. 
		Set<String> keys = map.keySet();	
		// 2단계 : Iterator 객체를 사용하여 끝까지 출력한다
		Iterator<String> iter = keys.iterator();
		// 3단계 : 객체가 없을때까지 향상된 for문으로 출력한다
		//		Iterator 패턴
		while(iter.hasNext()) {	//Iterator 객체 안의 객체를 확인한다. 있으면 true
			String tmp = iter.next();
			System.out.println(tmp + ":" + map.get(tmp));
			
		}
		
		//entrykey : key와 value를 같이 출력 할 수 있다
		Map<String, Integer> fruit = new HashMap<String, Integer>();
		fruit.put("apple", 1000);
		fruit.put("banana", 500);
		fruit.put("orange", 800);
		
		for(Map.Entry<String, Integer> entry : fruit.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		
		
	}

}
