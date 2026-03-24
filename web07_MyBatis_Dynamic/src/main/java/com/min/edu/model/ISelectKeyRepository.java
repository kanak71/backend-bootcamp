package com.min.edu.model;

import com.min.edu.dto.UserInfoVo;

public interface ISelectKeyRepository {
	
	//TODO 010 INSERT문을 실행하는 메소드
	public boolean insertUserInfo(UserInfoVo vo);
	
	//TODO 011 INSERT 실행 후 상세를 위한 SELECT 실행 메소드
	public UserInfoVo detailUserInfo(UserInfoVo vo);

}
