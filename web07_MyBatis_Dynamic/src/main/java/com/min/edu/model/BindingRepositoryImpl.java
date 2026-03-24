package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.dto.JobsVo;
import com.min.edu.mabatis.SqlSessionFactoryManager;

//TODO 002 Binding 구현 클래스
public class BindingRepositoryImpl implements IBindingRepository {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.BindingRepositoryImpl.";
	
	@Override
	public List<JobsVo> binding01(Map<String, Object> map) {
		log.info("binding01 실행 : {}", map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"binding01", map);
	}
	
	@Override
	public List<JobsVo> binding02(String key) {
		log.info("bingding02 실행 : {}", key);
		return manager.openSession().selectList(NS+"binding02", key);
	}
}
