package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.model.AnswerboardDaoImpl;
import com.min.edu.model.IAnswerboardDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/pagingBoard.do")
public class PagingBoardListServlet extends HttpServlet{
	
	private static final long serialVersionUID = -1117971510144219240L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("PagingBoardListServlet GET 페이징 처리");
		
		IAnswerboardDao dao = new AnswerboardDaoImpl();
		
		//1) 요청 페이지의 parameter 처리
		String requestParam = (req.getParameter("page") == null) ? "1" : req.getParameter("page");
		
		//2) 페이징 처리를 위해서 필요한 값
		int currentPage = Integer.parseInt(requestParam);	//요청된(현재)페이지
		int pageBlock = 5;	//한 그룹에 보여줄 페이지의 개수
		int pageSize = 10;	//한 화면에 보여줄 게시글의 개수
		int totalCount = dao.selectCountBoard();	//글의 총 개수
		
		//3) 필요값 계산
		//총 페이지 개수, 시작 페이지 숫자, 전체 페이지 계산, 끝숫자
		int startPage = ((currentPage -1)/pageBlock) * pageBlock +1;  //((1-1)/5)*5 +1 => 1
		int endPage = startPage + pageBlock -1;
		
		//endPage가 pageBlock의 갯수만큼 글의 개수가 없는 경우 : 110, 120개가 처리되는게 아니라 101, 102 처리 되는 경우, 끝의 endPage를 변경
		int totalPage = (int)Math.ceil((double)totalCount/pageSize);
		
		//마지막 페이지의 일반연산이 전체페이지(totalPage)보다 크면 값이 없다. 따라서 값을 totalPage를 endPage로 사용한다
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		//------글 리스트를 가져온다
		// 해당 페이지
		int offSet = (currentPage -1)*pageSize;	//1 => 0 시작, 2 => 10 부터 시작 -> 몇개를 가져올건데 pageSize
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offSet", offSet);
		map.put("pageSize", pageSize);
		List<AnswerboardDto> lists = dao.selectPageBoard(map);
		
		// 게시글의 리스트와 페이징 처리된 값
		req.setAttribute("lists", lists);
		
		//페이징 처리된 값
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("pageSize", pageSize);
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/pagingBoardList.jsp").forward(req, resp);
	}
	
}
