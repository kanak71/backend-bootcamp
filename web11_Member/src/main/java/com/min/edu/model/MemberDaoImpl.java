package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.dto.MemberDto;
import com.min.edu.support.SqlSessionSupport;

//TODO 007 기능 정의 구현 DAO
public class MemberDaoImpl implements IMemberDao {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionSupport.getFactory();
	private final String NS = "com.min.edu.model.MemberDaoImpl.";

	@Override
	public MemberDto getLogin(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getLogin", map);
	}

	@Override
	public MemberDto getUserInfo(String id) {
		log.info("사용자 상세 정보 : {}" , id);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getUserInfo", id);
	}

	@Override
	public Integer updateUserInfo(MemberDto dto) {
		log.info("사용자 정보 수정 : {}", dto);
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateUserInfo", dto);
	}

	@Override
	public Integer delUser(String id) {
		log.info("사용자 삭제 : {}", id);
		SqlSession session = manager.openSession(true);
		return session.delete(NS+"delUser", id);
	}

	@Override
	public Integer insertUser(MemberDto dto) {
		log.info("사용자 입력 : {}",dto);
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertUser", dto);
	}

	@Override
	public String duplidateId(String id) {
		log.info("중복 아이디 조회 : {}", id);
		SqlSession session = manager.openSession(false);
		return session.selectOne(NS+"duplidateId", id);
	}

	@Override
	public List<MemberDto> getAllUserState() {
		log.info("사용가능 사용자 조회");
		SqlSession session = manager.openSession(false);
		return session.selectList(NS+"getAllUserState");
	}

	@Override
	public List<MemberDto> getAllUser() {
		log.info("사용자 전체 조회");
		SqlSession session = manager.openSession(false);
		return session.selectList(NS+"getAllUser");
	}

	@Override
	public Integer updateAuthUser(Map<String, Object> map) {
		log.info("사용자 권한 수정 : {}", map);
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateAuthUser", map);
	}

}
