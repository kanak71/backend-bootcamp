package com.min.edu.exam;

import java.util.Arrays;

//정리 : shallow 주소값을 전달 받으면 원본과 바라보는 객체가 같다
//		deepCopy 같은 타입, 같은 값을 가진 객체를 만들어서 전달해주는 형식
//		
public class Shallow_Deep {
	
	//JPA 영속성 제거 코드, Production 코드, Jpql 작성, fetch, Transaction
	public void deepCopy() {
		String[] strs = new String[] {"d","r","e","a","m"};
		//첫번째 index방식
		// 1) 객체가 담길 수 있는 공간을 만들고 해당 객체의 index에서 값을 꺼내서 대입해주는 방법
		String[] strsCopy = new String[strs.length];	//strs와 같은 크기의 공간을 가진, null로 초기화되어 있는 array
		for (int i = 0; i < strsCopy.length; i++) {
			strsCopy[i] = strs[i];
		}
		
		//두번째 clone방식 : 모든 java의 객체는 object에 의해서 만들어진다. 따라서 Cloneable이 구성되어 있다면 해당 객체는 객체복제가 가능한 객체가 된다
		String[] strsClone = strs.clone();	//strs배열과 주소는 다르지만 속의 값은 같음

		//세번째 메모리에 요청(특수), java.lang.System
		String[] strsSystem = new String[10];	//null로 초기화 된 10개의 공간을 가지고 있다
		//원본, 원본의 복사 시작 인덱스, 복사 객체, 복사 객체의 시작점, 몇개
		System.arraycopy(strs, 2, strsSystem, 3, 2);
		
		System.out.println("index 복사 : " + Arrays.toString(strsCopy));
		System.out.println("clone 복사 : " + Arrays.toString(strsClone));
		System.out.println("System 복사 : " + Arrays.toString(strsSystem));
		
		//결론 객체의 확인, hashcode를 확인하면 된다
		//hashcode가 다르면 다른 객체이다
		System.out.println(strs.hashCode());
		System.out.println(strsCopy.hashCode());
		System.out.println(strsClone.hashCode());
		System.out.println(strsSystem.hashCode());
		
	}
	
	//앝은 복사
	public void shallow() {
		//참조타입은 객체를 찾아 갈 수 있는 주소를 전달받느다
		int[] arr = {1,2,3,4};
		int[] arrCopy = arr;
		
		System.out.println("원본 :" + Arrays.toString(arr));
		System.out.println("복사 :" + Arrays.toString(arrCopy));
		
		//복제된 arrCopy의 값을 변경하면 원본의 arr도 같이 변경될까?
		//결론 : 같은 객체를 바라보고 있기 때문에 arrCopy 혹은 arr을 변경하면 주소를 가지고 있는
		//		모든 변수는 변경된 객체를 사용하게 된다
		
		arrCopy[0] = 1000;
		System.out.println("원본 :" + Arrays.toString(arr));
		System.out.println("복사 :" + Arrays.toString(arrCopy));
	}

}
