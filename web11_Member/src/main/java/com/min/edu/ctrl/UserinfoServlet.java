package com.min.edu.ctrl;

import java.io.IOException;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

//TODO 010 사용자 상세 조회 Servlet 작성

@Slf4j
@WebServlet("/userInfoServlet.do")
public class UserinfoServlet extends HttpServlet {

	//HttpServlet을 extends한 자식클래스를 고유하게 구분하기 위한 값, 메모리가
	//serial Version UID
	private static final long serialVersionUID = 6537687547025758358L;
	
	//사용자 상세 조회 로그인 후 -> 로그인 저장정보(Session)에서 값(id)를 가져와서 사용
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserinfoServlet GET 사용자 상세 정보");
		
		//마이페이지(DDD)의 기능이기 때문에 로그인된 Session의 정보에서 id를 추출하여 값으로 사용하겠다
		HttpSession session = req.getSession();
		//모든 전송되는 Scope(request, session, application)은 값이 Object로 전달이 된다. 따라서 사용시(getAttribute) 다운케스팅 해야 한다
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		log.info("로그인된 사용자의 session 값 확인(id): {}", loginDto.getId());
		
		IMemberDao dao = new MemberDaoImpl();
		MemberDto dto = dao.getUserInfo(loginDto.getId());
		log.info("조회된 사용자의 상세 정보 : {}", dto);
		
		//값을 request scope : 후행 JSP만 값을 전송할 때 사용
		req.setAttribute("userInfo", dto);
		req.getRequestDispatcher("/WEB-INF/views/userInfo.jsp").forward(req, resp);	//ViewResoluver
		
		
		
	}

}
