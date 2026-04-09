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

//TODO 016 전체 사용자 조회 Servlet 작성
@Slf4j
@WebServlet("/userListServlet.do")
public class UserlistServlet extends HttpServlet {


	private static final long serialVersionUID = 9040525671541501342L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserlistServlet GET 사용자 전체 보기");
		
		IMemberDao dao = new MemberDaoImpl();
		List<MemberDto> lists = dao.getAllUser();
		
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/userList.jsp").forward(req, resp);
	}

}









