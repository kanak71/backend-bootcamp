package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

//TODO 008 Member DAO 테스트
public class MemberDao_JUnitTest {

	private IMemberDao dao;
	
	@Before
	public void setup() {
		dao = new MemberDaoImpl();
	}
	
	//1. 로그인
	@Test
	public void getLogin_test() {
		Map<String, Object> map = 
				new HashMap<String,Object>();
		map.put("id", "user01");
		map.put("password", "1111");
		
		MemberDto result = dao.getLogin(map);
		assertNotNull("로그인 성공", result);
	}
	
	//2 사용자 상세 정보
	@Test
	public void getUserInfo_test() {
		String id = "user01";
		MemberDto dto = dao.getUserInfo(id);
		assertNotNull("상세조회 성공", dto);
	}
	
	//3. 사용자 정보 수정
	@Test
	public void updateUserInfo_test() {
		MemberDto dto = new MemberDto();
		dto.setEmail("example@test.com");
		dto.setPassword("1111");
		dto.setId("user01");
		int cnt = dao.updateUserInfo(dto);
		assertEquals(1, cnt);
	}
	
	//4. 사용자 입력
	@Test
	public void insertUser_test() {
		MemberDto dto = new MemberDto();
		dto.setEmail("user02@test.com");
		dto.setId("user02");
		dto.setName("사용자2");
		dto.setPassword("1111");
		
		int cnt = dao.insertUser(dto);
		assertEquals(1, cnt);
	}
	
	//5. 사용자 삭제
	@Test
	public void delUser_test() {
		String id = "user02";
		int cnt = dao.delUser(id);
		assertEquals(1, cnt);
				
	}
	
	@Test
	public void duplidateId_test() {
		String id = "user03";
		String chk = dao.duplidateId(id);
		assertNull(chk);
		
		String id2="user02";
		String chk2 = dao.duplidateId(id2);
		assertNotNull(chk2);
	}
	
	@Test
	public void getAllUserState_test() {
		List<MemberDto> lists = dao.getAllUserState();
		System.out.println(lists.size());
		assertNotEquals(0, lists.size());
	}
	
	@Test
	public void getAllUser_test() {
		List<MemberDto> lists = dao.getAllUser();
		System.out.println(lists.size());
		assertNotEquals(0, lists.size());
	}
	
	@Test
	public void updateAuthUser_test() {
		Map<String, Object> map = 
					new HashMap<String, Object>();
		map.put("auth", "ROLE_USER");
		map.put("id", "user01");
		int cnt = dao.updateAuthUser(map);
		assertEquals(1,cnt);

		
	}
	
}
