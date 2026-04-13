package com.min.edu.ctrl;

import java.io.IOException;

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
@WebServlet("/writeBoard.do")
public class WriteBoardServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8530872236044807388L;

	//게시글 입력 화면 이동 GET
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("WriteBoardServlet GET 글작성 화면 이동");
		//@ViewResolver
		req.getRequestDispatcher("/WEB-INF/views/writeForm.jsp").forward(req, resp);
	}

	//요청받은 입력값 처리 POST
	//selectKey를 통해서 전달받은 seq를 통해서 입력되자 마자, 해당 입력된 글로 이동하겠다
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("WriteBoardServlet POST 글작성 입력");
		
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		
		String id = loginDto.getId();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		AnswerboardDto dto = new AnswerboardDto();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		
		IAnswerboardDao dao = new AnswerboardDaoImpl();
		boolean isc = dao.insertBoard(dto);
		//selectKey를 통해서 입력한 객체의 seq는 전달한 DTO에 담겨 있다
		
		if(isc) {
			resp.sendRedirect("./detailBoard.do?seq="+dto.getSeq());
		} else {
			resp.sendRedirect("./writeBoard.do");
		}
		
		
	}
	
	

}
