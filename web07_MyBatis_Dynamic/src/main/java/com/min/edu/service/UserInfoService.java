package com.min.edu.service;

import com.min.edu.dto.UserInfoVo;
import com.min.edu.model.ISelectKeyRepository;
import com.min.edu.model.SelectKeyRepository;

//TODO 012 SelectKey의 기능인 insert와 detail을 실행시켜 주는 Service
//			@Trancational
public class UserInfoService {
	
	private ISelectKeyRepository repository;
	
	public UserInfoService() {
		repository = new SelectKeyRepository();
	}
	
	/*
	 * 1) VO를 입력받아 insert를 실행
	 * 2) insert문의 <selectKey> 에 의해서 입력한 VO객체의 setSeq()에 생성된 값을 입력
	 * 3) VO를 다시 select를 실행
	 */
	
	public UserInfoVo insertAndSelect(UserInfoVo vo) {
		UserInfoVo result = null;
		boolean isc = repository.insertUserInfo(vo);
		System.out.println("^^ 1번 입력 실행");
		result = repository.detailUserInfo(vo);
		System.out.println("^^ 2번 조회 실행");
		
		return result;
	}

}
