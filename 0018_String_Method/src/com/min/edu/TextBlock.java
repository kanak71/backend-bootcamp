package com.min.edu;

//TextBlock은 java 13에서 미리보기로 기능되었고 17에서 표준이 되었다

//서버에서 javascript로 값을 전송해서 처리 HTML코드를 반환할 때 REST(비동기식처리) SPA에 구현할 때 사용
public class TextBlock {
	
	public void text() {
		//기존 처리방식의 문제점
		String str1 = "안녕하세요\n여러분";
		
		//""" 엔터 글작성 엔터 """ 이여야 함
		//문자열로 바라보면 안되고 객체로 봐야한다
		String str2 = """
				안녕하세요
				여러분""";

		//출력은 같다
		System.out.println(str1);	
		System.out.println(str2);	
			
		//str1과 str2는 같은 heap에 객체로 만들어졌다
		System.out.println(str1.hashCode());	//-249844287
		System.out.println(str2.hashCode());	//-249844287
		
		//str1과 str2는 같은 원래 객체가 오버라이드 되었다
		System.out.println(System.identityHashCode(str1));	//804564176
		System.out.println(System.identityHashCode(str2));	//804564176
		
		//str1과 str2는 같은 sp에 생성되어 있다
		System.out.println(str1.intern().hashCode());	//-249844287
		System.out.println(str2.intern().hashCode());	//-249844287
		
		//따라서 비교하면 true가 나온다
		//text block은 String으로 처리되는 것이 아니다
		System.out.println(str1.equals(str2));	//true
	}

}
