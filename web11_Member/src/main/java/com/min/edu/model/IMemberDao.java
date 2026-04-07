package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.MemberDto;

//TODO 006 기능 정의를 위한 Interface 작성
public interface IMemberDao {
	
	public MemberDto getLogin(Map<String, Object> map);

	public MemberDto getUserInfo(String id);

	public Integer updateUserInfo(MemberDto dto);
 
	public Integer delUser(String id);

	public Integer insertUser(MemberDto dto);

	public String duplidateId(String id);

	public List<MemberDto> getAllUserState();

	public List<MemberDto> getAllUser();
   
	public Integer updateAuthUser(Map<String, Object> map);


}
