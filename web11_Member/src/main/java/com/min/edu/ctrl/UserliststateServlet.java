package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

//TODO 015 사용가능 사용자 조회 Servlet 작성
@Slf4j
@WebServlet("/userListStateServlet.do")
public class UserliststateServlet extends HttpServlet {

	
	private static final long serialVersionUID = 6617717689841416942L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserliststateServlet GET 사용 가능 사용자 전체조회");
		
		IMemberDao dao = new MemberDaoImpl();
		List<MemberDto> lists = dao.getAllUserState();
		
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/userListStatus.jsp").forward(req, resp);
		
		
	}

}
