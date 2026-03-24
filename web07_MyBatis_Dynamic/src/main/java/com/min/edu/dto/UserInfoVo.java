package com.min.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//TODO 003 UserInfo 테이블과 연결되는 DTO 객체
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserInfoVo {
	private int seq;
	private String name;
	private String tel;
	private String role;
	private String createat;
	private String univ_id;

}
