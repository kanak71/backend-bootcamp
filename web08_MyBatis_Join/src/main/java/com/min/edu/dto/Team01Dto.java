package com.min.edu.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Team01Dto {
	
	private String team_name;
	private String region_name;
	private String address;
	private String homepage; 
	
	private Player01Dto pDtos;

}
