package com.min.edu;

/*
 * 정리 : 기본타입은 값의 복제가 이뤄진다
 * 		참조타입은 주소를 전달하기 때문에 객체를 공유한다
 * 	결론 : 기본타입은 값이 복제되기 때문에 마지막에 입력된 값이 최종 값이다
 * 		  참조타입은 주소를 가지고 있는 모든 변수는 주소를 통해서 하나의 객체를 수정 및 삭제가 가능하다
 * 
 * Clone Pattern에 대해서 연구해 보세요. 참조타입을 복제가 가능한 형태로 만들어 주는 것
 * 			hashcode Override & equals, interface Cloneable
 */
public class Passing_Argument_Main {
	
	public static void main(String args[]) {
		ValueChange vc = new ValueChange();
	
		//TODO 002 기본타입 전달
		int n = 100;
		vc.change(n);	//기본타입은 값 복제, n과 전달된 argument는 다르다, 전달받은 change()는 100을 복제되어 전달받는다
		System.out.println("기본타입은 복제하여 전달 된다 : " + n);
		
		//TODO 003 참조타입 전달
		int[] arr = {100,200,300};
		vc.change(arr);
		System.out.println(arr[0]); //참조타입은 주소를 전달하기 때문에 잘못 사용하면 값이 어느 곳에서 변경되는지 알 수 없다
	}

}
