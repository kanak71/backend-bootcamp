package com.min.edu.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//TODO 002 쿼리테스트의 결과/입력에 따른 전달객체 작성 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDto {
	private String id;
	private String name;
	private String password;
	private String email;
	private String auth;
	private String enable;
	private Date joindate;

}
