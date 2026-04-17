package com.min.edu.anno02;

import lombok.Data;

//TODO 004 값을 저장하는 DTO 클래스
/*
 * Lombok의 @Data는
 * 	자주사용하는 Annotation을 모두 자동생성해줌
 * 	Getter, Setter, toString, equals, hashCode, 생성자
 */
@Data
public class Student {
	
	private String name;
	private String addr;
	private String age;

}
