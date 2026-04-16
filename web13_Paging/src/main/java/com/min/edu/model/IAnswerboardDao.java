package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDto;

public interface IAnswerboardDao {
	
	//전체글조회
	public List<AnswerboardDto> selectAllBoard();
	
	//TODO 003 페이지 기능 interface : 페이징에 따른 게시글 리스트
	public List<AnswerboardDto> selectPageBoard(Map<String, Object> map);
	//TODO 004 페이지의 그룹과 개수와 그룹을 계산하는 전체 글의 개수
	//		유의사항 : 권한, 계정에 따라서 글의 개수를 변경(where)해야 한다
	public int selectCountBoard();
	


}
