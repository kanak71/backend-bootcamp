package com.min.edu;


//java.lang.String에서 많이 사용되는 메소드 연습
public class StringMethod {
	
	//치환 메소드(정규화 표현식 - ai한테 물어보세요)
	public void replaceAll() { 
		//글자들이 있으면 숫자, 문자(대문자, 소문자) 제거
		String str = "!T%65b";	//특수문자 대문자 소문자 숫자가 포함되어 있는 문자열
		String regEx = "[^0-9a-zA-Z]";
		String result = str.replaceAll(regEx, " ");
		System.out.println("replaceAll 정규화 표현식 사용 : " + result);
	}
	
	public void replace() {
		String str = "pulsel"; //맥박
		String strChange = "purse";
		
		String change = str.replace("l", "r");
		System.out.println(change);
	}
	
	//빈공간 판단
	//문자열에서 값이 없다라는 정의가 다름
	//isBlank는 사용자가 안보이면 없다고 판단
	//isEmpty는 ""처럼 코드상 값이 없는 값이면 판단
	public void isBlank() {
		String str = "\u3000";
		str = "";
		//System.out.println("\u3000의 문자열 : " + str);
		
		//is로 시작되는 메소드는 다 판단 boolean 반환
		//isBlank isEmpty
		System.out.println(str.isBlank());	//true
		System.out.println(str.isEmpty());	//true
	}
	
	public void concat() {
		//String의 특징인 concatenation을 메소드로 만들어 냄
		String str1 = "hap";
		String str2 = "py";
		String str3 = str1+str2; //메모리 문제가 심하다.
		String srt4 = str1.concat(str2);	//최적화하여 만들어 놓은 메소드
		
		//한꺼번에 전송할때
		StringBuffer sb = new StringBuffer();
		sb.append(str1);
		sb.append(str2);
		System.out.println(sb.toString());
		
		//실시간으로 전송할때(값이 많이 변할 때)
		StringBuilder sbi = new StringBuilder();
		sb.append(str1);
		sb.append(str2);
		System.out.println(sbi.toString());
	}
	
	//문자열의 앞뒤의 white space를 제거
	//특수문자는 제거하지 못함, 정규화 표현식 혹은 replaceAll과 같이 사용해야함
	public void trim() {
		String str = "                 lion             ";
		String trimStr = str.trim();
		System.out.println(trimStr);
	}
	
	public void toCharArray() {
		//문자열은 문자형이 조합되어 있는 형태이다
		//따라서 문자열을 문자형으로 요소로 분해
		//문자열을 분해 문자형 "ab" 'a','b' => 기본타입의 리터럴 연산의 문제가 된다
		String str = "j2j";
		
		char a = 'j';
		char b = '2';
		char c = 'j';
		
		char[] strArray = {'j','2','j'};
		
		char[] strToChar = str.toCharArray();
		for (int i = 0; i < strToChar.length; i++) { //길이를 반환 length
			System.out.println(strToChar);
		}
		
	}
	
	//문자열을 분해해서 문자열로 반환하자
	//String 문자열의 조합 => index의 영역이 필요하다
	public void subString() {
		//범위를 포함하는 끝의 index -1
		String str = "happiess";	
		System.out.println(str.substring(4));	//iess
		System.out.println(str.substring(2,5));	//ppi
		
	}
	
	//java에서는 길이를 나타내는 메소드와 예약어
	//int[] 처ㅏ럼 배열 length 예약어 : 끝 index
	//String 에서는 length 메소드 : 문자열을 쪼개서 개수
	//JCF에서는 size() : 객체의 개수
	public void length() {
		String str = "happy new year";
		System.out.println(str.length());
	}
	
	//위치값이 있느냐? 없느냐? 있다면 어느쯤에 있는지, 위치의 index 반환해 주는 것
	//메일 주소 저장: example@test.co.kr => example과 test.co.kr 근데 id가 위치가 다름
	public void indexOf() {
		String str = "example@test.co.kr";
		//아이디와 도메인을 구분해주세요
		int idx = str.indexOf("@");	//@의 위치를 찾는다
		System.out.println("@의 위치 index값은? : " + idx);
		
		String id = str.substring(0, idx);	// 0~7-1까지 잘라온다
		String domain = str.substring(idx + 1);	//7+1부터 뒤에 끝까지
		
		System.out.println("아이디는" + id);
		System.out.println("도메인은" + domain);
	}
	
	//값이 존재하느냐
	//indexOf는 위치를 int 값으로 반환
	//contains를 존재여부를 판단
	public void contains() {
		String str = "cocoa";
		boolean isc = str.contains("co");
		System.out.println(isc);
	}
	
	//toCharArray는 문자열을 요소별로 모두 분해 => char[]로 반환하게 된다
	//charAt() 해당 index의 위치의 char값을 반환하게 된다
	public void charAt() {
		String str = "agree to disagree";
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);	//문자열을 문자형의 조합
			System.out.println(tmp);
		}
		
	}
	
	public void stringWarning() {
		//index : IndexOutofBoundaryException
		//배열, 길이가 있는 것들은 index를 넘어가는 경우의 코드가 발생
		//[1,2,3] 탐색 : -1 혹은 3은 없다.
		
		String str = "abcd";
		//subString, charAt : 문자열 분해
		//index, contains : 문자열 탐색
		System.out.println(str.substring(4));	//없는 index : 새로운 new String();
		//System.out.println(str.charAt(4));	//IndexOutofBoundaryException 발생
		
		System.out.println(str.indexOf("e")); //존재하면 해당 index가 나오고, 아니면 -1 반환된다
		System.out.println(str.contains("e")); 	//존재여부 t:f
	}	
	
}
