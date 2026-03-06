package com.min.edu.ext;

import java.util.Date;

import com.min.edu.MyClass;

//TODO 003 외부 + 물리적인 위치도 다른 곳에서 MyClass의 객체를 생성하고 접근한다
public class External_PackageClass {
	
	//TODO 증명 003 외부+package는 물리적인 위치가 다르므로
	//		private + default + protected를 접근할 수 없다
	public void exTest() {
		MyClass my = new MyClass();
		my.publicMethod();
		
		//---------------------------------------
		Date d = new Date();	//어떠한 클래스의 Date인지 알 수 없다 => import를 하면 확인할 수 있다
		java.util.Date dd = new java.util.Date();	//명시적 import
		
	}
	
	/*
	 * package : 는 물리적인 구분 구조이다(폴더)
	 * import : 작성하는 코드에서 사용되는 클래스는 명확하게 위치를 정의하는 것
	 * 사용용도 : package를 구분하는 기준
	 * 			사용 용도가 같은 것끼리 구분
	 * 			com.min.edu.service 값을 연결하고 처리해주는 집합
	 * 			ㄴBoardServive
	 * 			ㄴMemberService
	 * 			com.min.edu.dto 값을 req,resp할 때 사용하는 데이터 은닉화 객체 집합
	 * 			ㄴBoardDto
	 * 			ㄴMembeerDto
	 * 			com.min.edu.repository DB와 연결해서 값을 가져오는 집합
	 * 			ㄴBoardRepository
	 * 			ㄴMemberRepository
	 */

}
