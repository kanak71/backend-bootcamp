package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.min.edu.comm.Utils;
import com.min.edu.dto.MemberDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {


	private static final long serialVersionUID = 8540465007151988981L;

	//로그인 화면 이동 및 로그아웃 GET
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet GET 로그아웃");
		HttpSession session = req.getSession();
		session.invalidate(); //세션을 무효화 시킨다
		req.getRequestDispatcher("/WEB-INF/views/loginForm.jsp").forward(req, resp);
	}
	
	//로그인 정보를 통한 로그인 진행 POST
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet POST 로그인");
		
		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		log.info("LoginServlet 요청받은 값 : {}" ,map);
		
		IUserDao dao = new UserDaoImpl(); 
		MemberDto loginDto = dao.login(map);
		
		/*
		 * session을 사용하면 너무 좋은데, 왜 사용하지 않나요?
		 *  -> 노션 4월 13일
		 */
		if(loginDto == null) {
			// 라이브러리 개발, alert, paging, 파일 업로드 기능
			//alert
			Utils.servlet_alert(resp, "로그인 정보가 없습니다", "./loginServlet.do");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("loginDto", loginDto);
			resp.sendRedirect("./boardList.do");
		}
	}
	
	
	
}
