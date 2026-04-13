package com.min.edu.ctrl;

import java.io.IOException;

import com.min.edu.comm.Utils;
import com.min.edu.dto.AnswerboardDto;
import com.min.edu.dto.MemberDto;
import com.min.edu.model.AnswerboardDaoImpl;
import com.min.edu.model.IAnswerboardDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/replyBoard.do")
public class ReplyBoardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2933602381797152660L;
	
	//답글 입력 화면 이동 GET
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("ReplyBoardServlet GET 답글 입력 화면 ");
		
		//부모의 글을 화면에 보여주기 위해서 
		String seq = req.getParameter("seq");
		IAnswerboardDao dao = new AnswerboardDaoImpl();
		AnswerboardDto dto = dao.selectDetailBoard(seq);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/views/replyBoardForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("ReplyBoardServlet POST 답글 입력");
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		
		//화면에서 전달받는 값은 모두 문자열 <=> Spring Data Binding
		String id = loginDto.getId();
		String seq = req.getParameter("seq");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		AnswerboardDto dto = new AnswerboardDto();
		dto.setId(id);
		dto.setSeq(Integer.parseInt(seq));
		dto.setTitle(title);
		dto.setContent(content);
		
		IAnswerboardDao dao = new AnswerboardDaoImpl();
		boolean isc = dao.reply(dto);
		if(isc) {
			resp.sendRedirect("./boardList.do");
		} else {
			Utils.servlet_alert(resp, "답글작성 실패", "./boardList.do");
		}
		
	}
	
	
	
	
	
	
}
