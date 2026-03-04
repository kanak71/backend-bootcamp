package com.min.edu;

public class NullMain {
	
	/*
	 * 정의 : Null이란?
	 * 	클래스는 인스턴스화르 진행하면 메모리의 heap 영역에 만들어지게 된다 => 객체
	 *  즉, 객체명은 stack에 위치하게 되고 연결된 객체는 heap에 있게 된다 => 인스턴스화 했다
	 *  근데, 만약에 stack에 참조차입을 담을 수 있는 변수만 있고, 연결된 객체가 없다면, 코드에 문제를 발생
	 *  	따라서 null이라고 하는 공간을 연결하여 문법을 맞출 수 있도록 한다
	 *  
	 *   사용되지 않는 객체를 null로 입력하면 해당 객체는 JVM의 Garbage Collection이 메모리에서 삭제하는 대상이 된다
	 *   삭제되는 시간은 실기간 이거나 즉시가 아닙니다. 어느 정도의 시간이 필요하다
	 *   
	 */

	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println("객체확인 : " + obj); //객체확인 : java.lang.Object@1f32e575
		
		obj = null;	//heap의 연결된 new object()와 끊어 버리게 된다	//garbage Collection의 대상이 된다
		System.out.println("끊어진 객체 :" + obj);
		
		//***** 객체가 null이 되면 사용되는 객체가 없다. 따라서 이 표시를 위해서 NullPointException을 발생시킨다
		
		obj.getClass();
		//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
		//			at com.min.edu.NullMain.main(NullMain.java:26)

	}

}
