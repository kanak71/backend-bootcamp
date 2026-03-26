package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.AllDto;
import com.min.edu.dto.Team01Dto;
import com.min.edu.dto.Team04Dto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class PlayerDaoImpl implements IPlayerDao {
	
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS1 = "com.min.edu.join01.";
	private final String NS2 = "com.min.edu.join02.";
	private final String NS3 = "com.min.edu.join03.";
	private final String NS4 = "com.min.edu.join04.";
	private final String NS5 = "com.min.edu.join05.";
	
	
	
	 @Override
	public List<AllDto> join01() {
		SqlSession session = manager.openSession();
		return session.selectList(NS1+"join01");
	}
	 
	 @Override
	public List<Team01Dto> join02() {
		 SqlSession session = manager.openSession();
			return session.selectList(NS2+"join02");
	}
	 
	 @Override
	public List<Team01Dto> join03() {
		 SqlSession session = manager.openSession();
			return session.selectList(NS3+"join03");
	}
	 
	@Override
	public List<Team04Dto> join04() {
		SqlSession session = manager.openSession();
		return session.selectList(NS4+"join04");
	}

}
