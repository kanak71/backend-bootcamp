package com.min.edu.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//TODO 001 한개의 DTO로 모든 컬럼의 정보를 담는다
@Getter
@Setter
@ToString
public class AllDto {

	
	//Player 테이블과 매핑되는 멤버필드
	private String player_id;
	private String player_name;
	private int back_no;
	private String position;
	
	
	//Team 테이블과 매핑되는 멤버필드
	private String team_name;
	private String region_name;
	private String address;
	private String homepage; 
}
