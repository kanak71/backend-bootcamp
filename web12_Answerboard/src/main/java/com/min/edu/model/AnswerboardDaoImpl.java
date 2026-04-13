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
	public AnswerboardDto selectDetailBoard(String seq) {
		log.info("selectDetailBoard 상세조회 : {}", seq);	//값이 전달이 되지 않는다면, 부적적한열유형
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"selectDetailBoard", seq); 
	}

	@Override
	public boolean reply(AnswerboardDto dto) {
		log.info("reply 답글 작성 Transaction 처리 : {}", dto);
		SqlSession session = manager.openSession();	//Transaction을 처리
		int cnt = 0;
		
		try {
			cnt += session.update(NS+"replyUpdate", dto);
			cnt += session.insert(NS+"replyInsert", dto);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return (cnt>0)?true:false;
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		log.info("modifyBoard 글수정 : {}", map);
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"modifyBoard", map);
		return (n>0)?true:false;
	}

	//pass by reference : 입력DTO -> MyBatis <selectKey> : 입력 DTO에 setSeq() -> 입력DTO 확인
	//시나리오 : 새글이 입력된 후 작성된 글의 상세페이지로 이동한다
	//			식별자가 되는 seq가 쿼리문을 통해서 생성 -> 외부로 가져와서 -> selectDetailBoard에 사용해야 한다
	@Override
	public boolean insertBoard(AnswerboardDto dto) {
		log.info("insertBoard 새글입력");
		log.info("입력받은 DTO : {}", dto);
		SqlSession session = manager.openSession(true);
		int n = session.insert(NS+"insertBoard", dto);
		log.info("SQL문 후 DTO : {}", dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean deleteBoard(String seq) {
		log.info("deleteBoard DB삭제 : {}", seq);
		SqlSession session = manager.openSession(true);
		int n = session.delete(NS+"deleteBoard", seq);
		return (n>0)?true:false;
	}

	@Override
	public boolean multiDelete(List<String> list) {
		log.info("multiDelete 다중삭제, 단일삭제 : {}", list);
		SqlSession session = manager.openSession(true);
		int n = session.delete(NS+"multiDelete", list);
		log.info("삭제된 row의 갯수 : {}", n);
		return (n>0)?true:false;
	}

}
