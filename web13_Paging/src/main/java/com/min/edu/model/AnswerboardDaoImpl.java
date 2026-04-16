package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.support.SqlSessionSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnswerboardDaoImpl implements IAnswerboardDao {
	
	private SqlSessionFactory manager = SqlSessionSupport.getFactory();
	private final String NS="com.min.edu.model.AnswerboardDaoImpl.";	//일반적으로 NS를 oracle.properties 파일처럼 미리 값으로 등록해놓고 사용

	@Override
	public List<AnswerboardDto> selectAllBoard() {
		log.info("selectAllBoard 전체조회");
		SqlSession session = manager.openSession();	//select는 Transaction을 처리할 팔요가 없다. 따라서 openSession(false)로 처리한다
		return session.selectList(NS+"selectAllBoard");
	}
	
	@Override
	public List<AnswerboardDto> selectPageBoard(Map<String, Object> map) {
		log.info("페이징 처리된 게시글 리스트 : {}", map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"selectPagingBoard", map);
	}

	@Override
	public int selectCountBoard() {
		log.info("게시글 전체의 글 개수");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"selectCountBoard");
	}
	

}
