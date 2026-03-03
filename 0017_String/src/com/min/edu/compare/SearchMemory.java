package com.min.edu.compare;

//TODO 300 메모리에서 객체를 확인해보자
//			new를 했다면 객체는 reference와 hashcode를 가지고 있다
//			new String은 값이 같다면 reference는 다르지만 값으로 hashcode가 오버라이드 되어 있다
//			일반 객체(POJO)도 String과 같이 만들어 볼까?
public class SearchMemory {

	public static void main(String[] args) {
		
		String str1 = "rainbow";
		
		//자식클래스의 정보는 최상위 부모인 java.lang.object가 가지고 있다
		
		//TODO 301 hashcode()
		//	문자열이니까 오버라이드 된 hashcode
		System.out.println("SP의 rainbow의 hashcode :" + str1.hashCode());	//973576630

		
		//TODO 302 identityHashcode()
		//	오버라이드 되기 전에 VM이 부여한 원래의 hashcode를 확인해보자
		System.out.println("SP의 rainbow의 Override되기 전의 hashcode : " + System.identityHashCode(str1)); //989110044
		
		System.out.println("--".repeat(20));
		
		//new String("rainbow")와 비교해보자
		//결과 : reference 다르게 == 안된다
		//		hashcode로 값이 같은 오버라이드된 hashcode 값을 가지고 있다
		//		System.identityHashcode()를 사용하면 원래의 hashcode값을 알 수 있다
		
		//TODO 303
		String str2 = new String("rainbow");
		//TODO 303 == 기본타입비교(기본타입은 값비교, 참조타입은 주소비교)
		System.out.println("str1과 new str2를 비교 : " + (str1==str2));	//false
		//주소가 다르니깐, 같은 곳을 바라보고 있지, new는 반드시 ref, hashcode를 새로 생성하낟
		
		//TODO 304 각 객체의 hashcode를 통한 비교
		System.out.println("hashcode()를 통한 값 비교 : " + (str1.hashCode() == str2.hashCode()));	//true
		System.out.println("System의 identityHashcode()를 통한 비교 : " + (System.identityHashCode(str1) == System.identityHashCode(str2)));	//false

		//TODO 305 그러면 어차피 문자열은 String pool에 값을 가지고 있다면, 값으로 추적해서 값이 같다면 같은 값을 가진 객체로 판단 할 수 있다
		//intern() 메소드를 사용하면 된다
		System.out.println(str1.intern());	//rainbow
		System.out.println(str2.intern());	//rainbow
		System.out.println(System.identityHashCode(str1.intern()));	//989110044
		System.out.println(System.identityHashCode(str2.intern()));	//989110044
	}

}
