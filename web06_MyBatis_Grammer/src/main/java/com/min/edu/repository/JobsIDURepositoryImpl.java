package com.min.edu.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.dto.JobsDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class JobsIDURepositoryImpl implements IJobsIDURepository {
	
	private Logger log = LoggerFactory.getLogger(JobsIDURepositoryImpl.class);
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS="com.min.edu.repository.JobsIDURepositoryImpl.";
	
	//TODO 02001 구현
	/*
	 * manager.openSession(); DataSource를 통해서 DB에 접근하기 위핸 SqlSession을 가져다 준다
	 * oepnSession()을 사용할 때 argument를 필요로 한다.
	 *  ㄴ 기본값은 false : manuala commit
	 *  ㄴ 		 true : auto commit
	 *  
	 *  insert와 update가 동시동작되는 서비스라면 
	 *  ex) SqlSession session = manager.openSession(false);
	 *  	session.insert("","");
	 *  	session.update("","");
	 *  	session.commit();	//commit을 실행 할 수 있다
	 */
	@Override
	public int insert01(JobsDto inDto) {
		int cnt = 0;
		log.info("insert, openSession을 반드시 Auto Commit으로 작업");
		SqlSession session = manager.openSession(true);
		cnt = session.insert(NS+"insert01", inDto);
		
		return cnt;
	}
	
	//TODO 02101 구현
	@Override
	public int delete01(Map<String, Object> inMap) {
		int cnt = 0;
		SqlSession session = manager.openSession();	//기본 false
		cnt = session.delete(NS+"delete01", inMap);
		session.commit();
		return cnt;
	}
	
	//TODO 02201 구현
	@Override
	public int update01(JobsDto inDto) {
		return manager.openSession(true).delete(NS+"update01", inDto);
	}
	
	
	
	
	
}
