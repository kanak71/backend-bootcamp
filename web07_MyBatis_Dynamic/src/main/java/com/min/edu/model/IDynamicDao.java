package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.JobsVo;
import com.min.edu.dto.UserInfoVo;

public interface IDynamicDao {
	
	//TODO 021 IF 사용
	public List<JobsVo> getJobIf(Map<String, Object> map);
	
	//TODO 023 foreach 사용 List
	public List<JobsVo> getJobList(List<String> seqs);
	
	//TODO 025 foreach 사용 Map<String, String[]>
	public List<JobsVo> getJobMap(Map<String, String[]> map);
	
	//TODO 027 choose문을 통한 선택적 쿼리 작성
	public List<JobsVo> getJobChoose(JobsVo vo);
	
	//TODO 029 Trim을 통한 연결 쿼리 작성
	public List<JobsVo> getJobTrim(JobsVo vo);
	
	//TODO 031 set을 통한 ,의 삭제
	public int jobUpdateSet(JobsVo vo);
	
	//TODO 100 사용예제 sequence 테이블의 용도와 주의점
	//			다중 insert => transaction 문제의 해결
	public int insertUserInfoList(List<UserInfoVo> users);

}
