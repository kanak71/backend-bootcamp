package com.min.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * TODO 001 List
 * 정의 : List는 interface로 되어 있고, 자식이 List 인터페이스를 구현하여 특징을 가지고 있게 된다 ex) ArrayList
 * 특징 : index로 판별한다
 * 		객체를 생성하고 add를 통해서 객체를 입력하면 자동으로 크기가 증가
 * 		삭제하면 해당 위치의 공간이 삭제된다
 * 판단 : index / 객체로 판단 할 수 있다
 * 사용 : 게시판 - 게시판의 글 개수가 계속해서 변하기 때문에 array(String[])를 판단할 수가 없다. 증가되거나 감소되기 때문에
 * 		인접개수 - 친구찾기, Link DB
 */
public class List_Feature {
	
	// 객체 탐색 contains
	public void list_contains() {
		List<Integer> lists = new ArrayList<Integer>();
		lists.add(10);
		lists.add(100);
		lists.add(1000);
		
		//contains는 있느냐? 없느냐?
		int n = 100;	//기본타입 선언
		boolean isc = lists.contains(n);	//wrapper class 변경돼서 들어간다
		System.out.println("JCF의 개수 size() : " + lists.size());
		System.out.println("100 값이 있나요? " + isc);
		
		//위치(index)를 확인하고 싶다
		List<String> listsStr = new ArrayList<String>();
		listsStr.add("A");
		listsStr.add("B");
		listsStr.add("D");
		listsStr.add("A");
			
		System.out.println(listsStr.indexOf("B"));	//1
		System.out.println(listsStr.lastIndexOf("A"));	//3
		
		Integer ii = 1;
		System.out.println(ii.hashCode());	//1
		System.out.println(System.identityHashCode(ii));	//321001045
		
		//Array <-> List
		String[] strs = {"java", "html", "db"};
		ArrayList<String> strsList = new ArrayList<String>(Arrays.asList(strs));
		System.out.println(strsList); //List는 객체 출력을 안의 객체를 출력할 수 있도록 toString을 Override 되어 있다
		
		}
		
	
	
	
	
	
	/*
	 * <> Generic : 입력된 객체를 미리 타입을 선언하여 사용하는 방식
	 */
	public void list_check() {
		
		//참조타입 JCF는 참조타입만을 객체로 입력 할 수 있다
		//int <=> Integer : 기본타입을 참조타입으로 만든 객체
		List<Integer> lists = new ArrayList<Integer>();
		
		//java 9이후는 자동으로 변화되기 때문에 많은 부분을 학습할 필요는 없다
		//int <-> Integer : Integer은 Wrapper Class라고 명하고 - 기본타입을 참조타입으로 사용한다
		//bsil fd boolean char : 각 모두 Wrapper 클래스가 존재한다
		
		int n1 = 20, n2 = 30, n3 = 40;
		
		//입력 방법
		lists.add(n1);	//index 0 : 20
		lists.add(n2);	//index 1 : 30
		lists.add(n3);	//index 2 : 40
		
		//출력방법
		System.out.println(lists.get(0));
		System.out.println(lists.get(1));
		System.out.println(lists.get(2));
		
		n3 = 100;	//참조타입은 주소를 전달받는다. Wapper Class 복제(값전달)
		
		System.out.println(lists.get(0));
		System.out.println(lists.get(1));
		System.out.println(lists.get(2));
		
		System.out.println("--".repeat(20));
		
		//정의 : 삭제는 index를 통해서 삭제
		//	Object(객체)를 통해서
		//"int값은 index로 인식, Integer는 객체로 인식"
		int idx = 1;	//stack
		Integer obj = 40;	//heap
		
		//index 삭제
		//삭제가 되면 해당 index를 삭제하고 뒤에 있는 index 변경 (이제 2였던 애가 1이 됨)
		lists.remove(idx);	
		
		//object로 삭제
		lists.remove(obj);
		
		for (int i : lists) {
			System.out.println(i);
		}
		
		
		
	}

}
