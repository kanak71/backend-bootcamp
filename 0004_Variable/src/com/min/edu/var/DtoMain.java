package com.min.edu.var;

public class DtoMain {

	public static void main(String[] args) {
		
		InfoUserDto dto01 = new InfoUserDto();
		
		dto01.name = "도우너";
		dto01.hobby = "바이올린";
		dto01.etc = "기타";
		
		dto01.make(100);	//argument를 필요로 한다
		

	}

}
