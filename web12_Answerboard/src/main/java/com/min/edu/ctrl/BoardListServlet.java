package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/boardList.do")
public class BoardListServlet extends HttpServlet {
	
	private static final long serialVersionUID = -4508262440206690789L;
	
	//전체글 리스트 GET
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("BoardListServlet GET : 모든 게시글 조회");
		IAnswerboardDao dao = new AnswerboardDaoImpl();
		List<AnswerboardDto> lists = dao.selectAllBoard();
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("WEB-INF/views/boardList.jsp").forward(req, resp);
		
	}
	
	

}
