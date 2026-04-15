package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
@WebServlet("/modifyBoard.do")
public class ModifyBoardServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3078945437762942590L;

	//게시글 수정 화면 이동 GET
	//내글만 수정 가능하도록 만듦
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("ModifyBoardServlet GET 게시글 수정 화면 이동");
		
		String seq = req.getParameter("seq");
		//수정은 자신이 쓴 글만 수정 할 수 있도록 함
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		
		IAnswerboardDao dao = new AnswerboardDaoImpl();
		AnswerboardDto dto = dao.selectDetailBoard(seq);
		
		if(dto.getId().equals(loginDto.getId())) {
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("/WEB-INF/views/modifyBoardForm.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("./loginServlet.do");
		}
	}

	//게시글 수정 입력 POST
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("ModifyBoardServlet POST 게시글 입력");
		
		String seq = req.getParameter("seq");
		String content = req.getParameter("content");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("content", content);
		
		IAnswerboardDao dao = new AnswerboardDaoImpl();
		boolean isc = dao.modifyBoard(map);
		if(isc) {
			resp.sendRedirect("./detailBoard.do?seq="+seq);
		} else {
			resp.sendRedirect("./modifyBoard.do?seq="+seq);
		}
		
	}


	
}
