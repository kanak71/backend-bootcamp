package com.test.edu;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.dto.UserInfoVo;
import com.min.edu.mabatis.SqlSessionFactoryManager;

public class MyBatis_JUnitTest {

	@Test
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	
	//TODO 004 lombok을 통한 setter/getter/toString/builder 테스트
	@Test
	public void lombok_test() {
		UserInfoVo vo = new UserInfoVo();	//생성자 확인
		vo.setName("지구");
		System.out.println(vo.getName());
		
		//builder : 동적으로 생성자를 사용하는 방법
		//default / 모든 멤버필드를 가지고 있는 생성자 => 필요에 의해서 일부분을 가지고 있는 동적의 입력이 필요한 경우
		UserInfoVo vo_builder = new UserInfoVo()
									.builder()
									.name("화성")
									.tel("004")
									.build();
		System.out.println(vo_builder);
		
	}

}
