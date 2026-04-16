package com.min.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.dto.MemberDto;
import com.min.edu.model.AnswerboardDaoImpl;
import com.min.edu.model.IAnswerboardDao;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;
import com.min.edu.support.SqlSessionSupport;

public class Answerboard_JUnit {

	
	private IAnswerboardDao answerboardDao;
	private IUserDao userDao;
	
	@Before
	public void createDao () {
		answerboardDao = new AnswerboardDaoImpl();
		userDao = new UserDaoImpl();
	}
	
	
//	@Test
	public void test() {
		SqlSessionFactory manager = SqlSessionSupport.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	
//	@Test
	public void selectAllBoard_test() {
		List<AnswerboardDto> lists = answerboardDao.selectAllBoard();
		assertNotEquals(0, lists.size());
	}
	
//	@Test
	public void selectDetailBoard_test() {
		AnswerboardDto dto = answerboardDao.selectDetailBoard("1");
		//selectOne으로 사용하면 공집합(쿼리의 결과가 없는 경우)는 null로 나오기 때문에 
		assertNotNull(dto);
	}
	
//	@Test
	public void login_test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "user03");
		map.put("password", "1111");
		MemberDto dto = userDao.login(map);
		assertNotNull(dto);
	}
	
//	@Test
	public void insertBoard_test() {
		AnswerboardDto dto = new AnswerboardDto();
		dto.setId("user03");
		dto.setTitle("새로운 Root 작성 test");
		dto.setContent("새로운 내용 작성 test");
		boolean isc = answerboardDao.insertBoard(dto);
		assertTrue(isc);
	}
	
	@Test
	public void modifyBoard_test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", 4);
		map.put("content", "수정 글 내용 작성 test");
		boolean isc = answerboardDao.modifyBoard(map);
		assertTrue(isc);
	}
	
	//@Test
	public void reply() {
		AnswerboardDto dto = new AnswerboardDto();
		dto.setId("admin");
		dto.setTitle("답글 작성 test");
		dto.setContent("답글 내용 작성 test");
		//부모의 seq를 입력받아야 한다. UI에서 전달 받아야 한다
		dto.setSeq(4);
		
		boolean isc = answerboardDao.reply(dto);
		assertTrue(isc);
	}
	
	//check 사항 : <foreach>문을 통한 dynamic 쿼리의 생성 ("","")
	//insert, update, delete는 모두 성공한 row의 개수를 반환한다
	//주의사항 : 실행된ㄷ 쿼리가 y->n, n ->y, or y->y, n->n 모두 성공이다 : 쿼리가 실행되었기 때문에
	//			실행되는 쿼리의 값이 없는 row의 실행은 성공개수로 판단하지 않는다
	@Test
	public void multiDelete_test() {
		List<String> seqs = List.of("1","2");
		boolean isc = answerboardDao.multiDelete(seqs);
		assertTrue(isc);
	}
	
//	@Test
	public void deleteBoard_test() {
		boolean isc = answerboardDao.deleteBoard("5");
		assertTrue(isc);
	}
	

}
