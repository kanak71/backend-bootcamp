package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDto;

public interface IAnswerboardDao {
	
	//전체글조회
	public List<AnswerboardDto> selectAllBoard();
	
	//상세글 조회
	public AnswerboardDto selectDetailBoard(String seq);
	
	//답글 Transaction을 통해서 update 실패거나 혹은 insert가 실패하면 모두 Rollback
	//Spring Framwork에서는 IoC(제어역전)을 통해서 Service가 Transaction을 처리
//	replyInsert
//	replyUpdate
	public boolean reply(AnswerboardDto dto);
	
	//글 수정
	public boolean modifyBoard(Map<String, Object> map);

	//글 입력
	public boolean insertBoard(AnswerboardDto dto);
	
	//삭제 (DB) 완전삭제
	public boolean deleteBoard(String seq);
	
	//다중삭제(전체글 화면에서 checkbox를 통해서 여러개 입력받아 삭제)
	public boolean multiDelete(List<String> lists);


}
