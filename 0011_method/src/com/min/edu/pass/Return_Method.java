package com.min.edu.pass;


//TODO 201 return type : 메소드를 실행시키면 특정 결과를 실행(호출)된 곳으로 반환하는 메소드 값
public class Return_Method {
	/*
	 * 메소드인데 어떠한 것도 반환하지 않는 : void 선언
	 * 메소드인데 특정한 값(Type)를 반환하는 것 : Type을 작성한다
	 */
	
	//요구사항 분석 : 
	/*
	 * 이름과 나이를 입력받아 문자를 만들어 String 문자열로 반환하는 메소드
	 * 예시> 전민균 10 <= 입력값    -> "나의 이름은 전민균이고 나이느 10살 입니다" <- 출력값
	 * 
	 */
	
	/**
	 * 문자와 숫자를 입력받아 "나의 이름은 %s이고 나이는 %d 입니댜" 를 완성하는 메소드 <br>
	 * @param name Strtig
	 * @param age int
	 * @return "나의 이름은 %s이고 나이는 %d 입니댜"
	 */
	
	public String retunValue(String name, int age) {
		//우리 문자열 변수로 만드려면 너무너무 힘들어 작성할때 "나의 이름은 " + name + " " + " " .... 
		//다른 방법?
		//Binding 문법을 사용한다
		//`나의 이름은${name}` : grave 표현식
		//${}는 값을 전달, ${} '값'을 전달
		
		//%s sentence(단어문자), %d decimal(숫자), %f(floating)
		
		String result = String.format("나의 이름은 %s이고 나이는 %d 입니댜", name, age);
		return result;
		
	}
	
	//TODO 300 skip return
	//			Loop 특수키 : break(멈추다), continue(처음부터)
	//넘어감
	
	//웹서비스 : 로그인을 했니? 그럼 다음 HTML을 표현하고 아니면 하지마
	//
	public void myPrint(String str) {
		if(str == "") {
			return; //skip return
		}
		System.out.println(str);
	}

}
