package com.min.edu;

import java.util.Arrays;

/*
 * 정리 : Array는 Class가 존재하지 않는 객체,  java.lang.String.charAt()
 * 		 참조타입(mutable) : 주소를 통해 해당 객체를 접근 할 수 있다
 * 		 				 : 주소를 전달, 복제가 아니다(위치를 알려줌)
 * 		하나의 묶음이고 주소에 해당하는 index를 통해서 내부 값을 호출 및 입력한다
 */

public class Array_declaration {

	public static void main(String args[]) {
		int x[]; //1차원 선언방법 [, , , , , ] : 초기값은 타입의 기본 값으로 입력되어 진다(int 기본값 0)
		
		//첫번째 선언방법 : new와 값을 입력하는 방법
		int[] arr1 = new int[] {20, 21, 22};	//class로 존재하지 않기 때문에 생성자가 없다!!!!!!
		
		//두번째 선언방법 : 값을 입력한다
		int[] arr2 = {1,2,3,4};	//값의 개수에 따라 크기가 만들어진다
		
		//세번째 선언방법 : 타입으로 초기화된 공간을 만든 후 index를 통해 값을 입력한다
		int[] arr3 = new int[3]; //int의 초기값인 0으로 된 3개의 공간을 만든다 [0,0,0] // *** IndexOutOfBoundsException 조심
		arr3[0] = 10;
		arr3[1] = 11;
		arr3[2] = 12;
		
		//2차원 선언 방법
		String [][] n1 = {{"00", "01"},{"10","11"},{"20","21"}}; //ndArray
		String [][] n2 = new String[1][2];
		
		//=========출력
		int arr[] = {3,2,1};
		System.out.println(arr);	//[I@1f32e575 : [-배열이다, @-접속사, 16진수(객체니까)
		//첫번째 출력 방법 index
		//array는 예약어로 되어 있는 length를 사용을 통해 길이를 반환한다
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//두번째 출력방법 enhanced for(향상된 for문)
		for (int i : arr) {	//arr에 있는 모든 값을 int i로 값을 전달하여 i를 출력하면 값이 출력된다
			System.out.println("향상for문 :" + i);	//웹에서 많이 사용, paging, 게시판 등등
		}
		
		//정리 : Array는 객체이지만 class가 없다. 기능이 없다. 그래서 Array의 기능만 가지고 있는 클래스를 따로 만들어 놨다. java.util.Arrays
		//세번째 출력 방법 : Arrays에 toString()을 사용한다
		//**결론 : 이쁘게 나온다. 하지만 출력문 이외엔 사용하면 안된다.
		//		이유는 [] 표시되고, 값과 값 사이에 |(공백),(콤마) 등이 있다
		String arrPrint = Arrays.toString(arr);
		System.out.println("java.util.Arrays 사용 : " + arrPrint);	//java.util.Arrays 사용 : [3, 2, 1]
		
		//결론 : 참조타입이기 때문에 객체명을 통해서 처리하면 된다
		//		즉, 기본타입처럼 새로운 변수에 담지 않아도 된다
		//java.util.Arrays에서 많이 사용하는 메소드는?
		//힌트 : 많이 사용하기 때문에 static으로 되어있다
		//정렬(sort)
		Arrays.sort(arr);
		System.out.println("java.util.Arrays sort 사용 : " + Arrays.toString(arr));	//java.util.Arrays sort 사용 : [1, 2, 3]
		
		//전체 값이 타입으로 초기화되기 때문에 전체값을 입력
		Arrays.fill(arr, -1);
		System.out.println(Arrays.toString(arr));
		
		
			
	}
}
