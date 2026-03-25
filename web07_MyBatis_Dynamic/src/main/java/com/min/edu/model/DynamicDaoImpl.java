package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.dto.JobsVo;
import com.min.edu.dto.UserInfoVo;
import com.min.edu.mabatis.SqlSessionFactoryManager;

public class DynamicDaoImpl implements IDynamicDao {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS ="com.min.edu.model.DynamicDaoImpl.";
	
	//TODO 022 IF 사용 구현
	@Override
	public List<JobsVo> getJobIf(Map<String, Object> map) {
		log.info("Map의 전송은 반드시 mapper xml 바인되는 이름과 같아야 한다 {}" ,map);
		SqlSession session = manager.openSession();
		
		
		return session.selectList(NS+"getJobIf", map);
	}
	
	//TODO 024 foreach 구현 List
	@Override
	public List<JobsVo> getJobList(List<String> seqs) {
		log.info("List는 collection의 값이다");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getJobList", seqs);
	}
	
	
	//TODO 026 foreach 구현 Map
	@Override
	public List<JobsVo> getJobMap(Map<String, String[]> map) {
		log.info("Map은 collection의 값 : key를 collection의 값으로 작성");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getJobMap", map);
	}
	
	
	//TODO 028 choose 구현
	@Override
	public List<JobsVo> getJobChoose(JobsVo vo) {
		log.info("job_id 혹은 job_title을 통한 선택적 쿼리 동작 {}" ,vo);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getJobChoose", vo);
	}
	
	//TODO 030 Trim 구현
	@Override
	public List<JobsVo> getJobTrim(JobsVo vo) {
		log.info("job_id와 job_title의 값을 확인하여 연속으로 작성 {}", vo);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getJobTrim", vo);
	}
	
	//TODO 032 update의 set을 통한 구현
	@Override
	public int jobUpdateSet(JobsVo vo) {
		log.info("set은 SQL문의 끝 , 를 삭제한다");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"jobUpdateSet", vo);
	}
	
	//TODO 010 구현
	@Override
	public int insertUserInfoList(List<UserInfoVo> users) {
		log.info("여러명의 사원 입력 : {}", users);
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertUserInfoList", users);
	}
	
	
	

}
