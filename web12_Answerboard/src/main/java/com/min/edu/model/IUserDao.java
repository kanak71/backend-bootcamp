package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.MemberDto;

public interface IUserDao {
	
	public MemberDto login(Map<String, Object> map);

}
