package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.JobsVo;

//TODO 006 Binding 학습을 위한 interface
public interface IBindingRepository {
	
	//TODO 008 #과 $의 바인딩 사용방법
	public List<JobsVo> binding01(Map<String, Object> map);
	
	//TODO 009 like문의 # 바인딩
	public List<JobsVo> binding02(String key);
	
}
