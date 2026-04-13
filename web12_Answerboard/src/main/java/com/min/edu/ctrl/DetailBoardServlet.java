package com.min.edu.ctrl;

import java.io.IOException;

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
@WebServlet("/detailBoard.do")
public class DetailBoardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 361942911712386764L;
	
	//게시글 상세 보기 GET
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DetailBoardServlet GET 글상세");
		
		String seq = req.getParameter("seq");
		IAnswerboardDao dao = new AnswerboardDaoImpl();
		AnswerboardDto dto = dao.selectDetailBoard(seq);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/views/detailBoard.jsp").forward(req, resp);
	}

}
