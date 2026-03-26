package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.AllDto;
import com.min.edu.dto.Team01Dto;
import com.min.edu.dto.Team04Dto;
import com.min.edu.model.IPlayerDao;
import com.min.edu.model.PlayerDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class MyBatis_Join_JUnitTest {
	
	private IPlayerDao dao;

	@Before
	public void createDao() {
		dao = new PlayerDaoImpl();
	}
	
//	@Test
	public void create() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	
//	@Test
	public void join01() {
		List<AllDto> lists = dao.join01();
		System.out.println(lists.get(0));
	}
	
//	@Test
	public void join02() {
		List<Team01Dto> lists = dao.join02();
		System.out.println("조회된 객체의 개수 : " + lists.size());
		System.out.println(lists.get(0));
		System.out.println(lists.get(0).getPDtos());
	}
	
	//DTO 하나의 OGNL로 사용한다면 자식의 개수 출력된다
	//하지만 mybatis의 <collection>문법을 사용한다면 의존하는 부모의 개수만큼 나온다
	// 해결 : 멤버필드는 Player01Dto -> List<Player01Dto> 변경하여 사용하면
	//		1:n의 관계로 구성이 된다
//	@Test
	public void join03() {
		List<Team01Dto> lists = dao.join03();
		System.out.println("조회된 객체의 개수 : " + lists.size());
	}
	
	@Test
	public void join04() {
		List<Team04Dto> oneToMany = dao.join04();
		// 15개 : team(1)에 여러개(n)의 player가 소속되어서 들어가 있기 때문에
		System.out.println("조회된 객체의 개수 : " + oneToMany.size());
		
		System.out.println("index 0에 소속되어 있는 선수 조회 \n" + oneToMany.get(0));
		System.out.println("index 0에 소속되어 있는 선수 인원 \n" + oneToMany.get(0).getPlayerDtos().size());
		System.out.println("index 0(울산현대)에 소속되어 있는 선수의 첫번째 선수");
		System.out.println(oneToMany.get(0).getPlayerDtos().get(0));
	}
	
	

}
