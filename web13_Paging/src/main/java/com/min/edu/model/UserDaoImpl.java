package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.MemberDto;
import com.min.edu.support.SqlSessionSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDaoImpl implements IUserDao {

	@Override
	public MemberDto login(Map<String, Object> map) {
		log.info("login 로그인 : {}", map);
		SqlSessionFactory manager = SqlSessionSupport.getFactory();
		SqlSession session = manager.openSession();
		return session.selectOne("com.min.edu.model.UserDaoImpl.login", map);
	}

}
