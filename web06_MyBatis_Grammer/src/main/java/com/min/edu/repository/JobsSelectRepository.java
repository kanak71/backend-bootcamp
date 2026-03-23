package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.dto.JobsDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class JobsSelectRepository implements IJobsSelectRepository {
	
	//1) 사용자 로그
	private Logger log = LoggerFactory.getLogger(JobsSelectRepository.class);
	//2) SqlSessionFactory 객체
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	//3) 고유한 namespace를 상수 선언
	private final String NS = "com.min.edu.repository.JobsSelectRepository.";

	//TODO 01201 구현
	@Override
	public Integer select01(String id) {
		log.info("기본타입을 파라미터로 전송 \n 결과를 기본타입으로 반환받음");
		//쿼리를 실행하기 위한 Session 열어줌
		SqlSession session = manager.openSession();
		int result = session.selectOne(NS+"select01", id);
		
		
		return result;
	}
	
	//TODO 01301 구현
	
	@Override
	public JobsDto select02(String job_id) {
		log.info("기본타입을 사용하여 전달된 결과를 DTO로 처리 \n Mybatis에서는 mapper에 Parameter를 작성하지 않아도 자동으로 처리 된다");
		JobsDto dto = null;
		SqlSession session = manager.openSession();
		dto = session.selectOne(NS+"select02", job_id);
		return dto;
	}
	
	//TODO 01401 구현
	@Override
	public JobsDto select03(String job_id) {
		JobsDto dto = null;
		SqlSession session = manager.openSession();
		dto = session.selectOne(NS+"select03", job_id);
		return dto;
	}
	
	//TODO 01501 구현
	/* 입력값 IT_PROG
	 * {
	 *  "IT_PROG" : {
	 *  				JobsDto 객체
	 *  			}
	 * }
	 */
	@Override
	public Map<String, JobsDto> select04(String job_id) {
		Map<String, JobsDto> result = null;
		SqlSession session = manager.openSession();
		//selectMap(네임스페이스.아이디, 전달값, Map에서 키가 되는 값)
		result = session.selectMap(NS+"select04", job_id, "JOB_ID");
		return result;
	}
	
	//TODO 01601 구현
	@Override
	public JobsDto select05(JobsDto inDto) {
		JobsDto result = null;
		SqlSession session = manager.openSession();
		result = session.selectOne(NS+"select05", inDto);
		
		return result;
	}
	
	//TODO 01701 구현
	@Override
	public List<JobsDto> select06() {
		List<JobsDto> lists = null;
		
		SqlSession session = manager.openSession();
		lists = session.selectList(NS+"select06");
		
		return lists;
	}
	
	//TODO 01801 구현
	@Override
	public List<JobsDto> select07(Map<String, Object> map) {
		List<JobsDto> lists = null;
		SqlSession session = manager.openSession();
		lists = session.selectList(NS+"select07", map);
		
		return lists;
	}
	
	//TODO 01901 구현
	@Override
	public List<JobsDto> select08(Object obj) {
		List<JobsDto> lists = null;
		SqlSession session = manager.openSession();
		lists = session.selectList(NS+"select08", obj);
		return lists;
	}
	
	
	
	
	
	
	
	
	

}
