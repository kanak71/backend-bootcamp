package com.min.edu;

/*
 * 오늘의 목표
 * 개미수열, 수열 문제 중에서 Look and say 수열 코드
 * 세가지 방법 : + concat
 * 				StringBuilder => 굉장히 좋다 효율적이다
 * 				StringBuffer
 * 
 * 결론 : 
 * 	반복문으로 문자열 누적 -> 무조건 StringBuilder를 사용하라
 *  간단한 1~2회 연결 -> concat
 */ 

public class AntQuiz {
	
	public void antQuizIterator(int stage) {
		String val = "1";	//"11"넣지 않은 이유는 출력
		for (int i = 0; i < stage; i++) {	//층수 반복
			String result = andProcess(val);
			System.out.println(result);
			val=result; //결과를 재입력해서 사용하게 된다
		}
	}
	
	public String andProcess(String val) {
		String answer = "";	//최종결과를 누적하고 반환하는 변수 //concat을 위해서 // StringBuilder
		char init = val.charAt(0); //처음의 비교 대상 값을 문자열의 첫번째 값, 문자열은 문자형의 조합이다
		int cnt = 1; //무조건 자기 자신 한개를 가지고 있다
		for(int i=1; i<val.length(); i++) {
			if(init == val.charAt(i)) {	//기준점 뒤로 같은 값이 있느냐?
				cnt++; //뒤의 반복의 갯수
			} else {
				answer = answer + init + cnt;
				//비교대상을 변경
				init = val.charAt(i);
				cnt = 1;
			}
		}
		answer = answer + init + cnt;
		return answer;
	}
	

}
