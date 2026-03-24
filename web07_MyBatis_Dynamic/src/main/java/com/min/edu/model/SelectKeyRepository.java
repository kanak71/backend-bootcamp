package com.min.edu.model;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.dto.UserInfoVo;
import com.min.edu.mabatis.SqlSessionFactoryManager;

public class SelectKeyRepository implements ISelectKeyRepository {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS ="com.min.edu.model.SelectKeyRepository.";

	@Override
	public boolean insertUserInfo(UserInfoVo vo) {
		log.info("insertUserInfo 전달받은 vo값 : {}", vo);
		SqlSession session = manager.openSession(true);
		int n = session.insert(NS+"insertUserInfo", vo);
		return n==1 ? true:false;
	}

	@Override
	public UserInfoVo detailUserInfo(UserInfoVo vo) {
		log.info("detailUserInfo 전달받은 seq : {}", vo.getSeq());
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"detailUserInfo", vo);
	}

}
