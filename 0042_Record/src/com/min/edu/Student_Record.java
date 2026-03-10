package com.min.edu;

//TODO 001 Record 
//보일러플레이트 코드
public record Student_Record(String name, int age) {
	
	public Student_Record{
		if(age < 0) {
			throw new IllegalArgumentException("나이는 음수가 될 수 없습니다");
			
		}
	}
	
	//메소드 추가
	public String introduce() {
		return String.format("안녕하세요 제 이름은 %s이고 나이는 %d 입니다", name, age);
	}
	
	

}
