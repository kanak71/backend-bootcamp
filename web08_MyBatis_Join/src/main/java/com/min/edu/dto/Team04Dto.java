package com.min.edu.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Team04Dto {
	
	private String team_name;
	private String region_name;
	private String address;
	private String homepage;
	
	//TODO 300 하나의 Team에 여러개의 Player가 소속된다
	private List<Player04Dto> playerDtos;
	
	

}
