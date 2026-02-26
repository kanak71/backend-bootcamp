package com.min.edu;	// 0001 package class 문서의 물리적 구분 및 실행을 위한 구분
						// 권고 사항 : java 파일은 단위 이상, 웹 개발 3단위 이상을 작성해 주세요(표준이다)
						// 없으면 안됨. ctrl+shift+c 단줄 주석  ctrl+shift+/ 여러줄 주석

/*
 * { } : code block 혹은 Block 내용을 정의하는 곳. 로직, 코드를 작성 하는 곳
 */


//public, class ... : 예약어로 되어 있어 변수로 사용 안됨
public class InitialClass {	//Class 기능(method)가 포함되어 있는 영역 : 반드시 파일명과 같아야 함
	
	// 이름() : 기능(method) 정의되어 있는 곳, 출력, 로직 등등 작성하는 부분
	public static void main(String[] args) {	//메인메소드 : 프로그램의 시작과 끝, main 메소드가 없으면 실행이 되지 않는다
		System.out.println("Hello");	//외부 기능을 호출(System의 하위에 있는 out 하위에 있는 println을 실행시틴다. 그때 값을 가져간다)

	}	//method 영역

}	//class 영역
