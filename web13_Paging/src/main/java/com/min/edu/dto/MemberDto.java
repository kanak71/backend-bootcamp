package com.min.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//로그인시 사용자의 정보를 가지고 있는 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
	
	private String id;
	private String name;
	private String email;
	private String auth;
}
