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

//TODO 011 사용자 정보 수정 Servlet 작성
@Slf4j
@WebServlet("/userModifyServlet.do")
public class UsermodifyServlet extends HttpServlet {

	private static final long serialVersionUID = 7813672027175059399L;
	
	//입력 내용을 작성하기 위한 화면(form)으로 이동할 때 사용
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UsermodifyServlet GET 사용자 정보 수정 화면 이동");
		
		//Session의 정보에서 내 정보를 조회 보내줌
		//만약 없다면 => 로그아웃(/loginServlet.do GET)요청
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		if(loginDto == null) {
			resp.sendRedirect("./loginServlet.do");	//=>GET으로 요청하면 로그아웃
			return;
		}
		
		IMemberDao dao = new MemberDaoImpl();
		MemberDto info = dao.getUserInfo(loginDto.getId());
		
		req.setAttribute("userInfo", info);
		req.getRequestDispatcher("/WEB-INF/views/modifyForm.jsp").forward(req, resp);
	}
	
	// 입력 내용을 화면으로 부터 전달받아 DB에 입력 할 때 사용
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UsermodifyServlet POST 사용자 정보 수정 입력");
		//1) 인코딩 확인
		//2) Session 확인
		//3) email 이거나 password를 DTO 처리 해야 하기 때문에 => BuilderPattern
		
		//1) - 계속하는 작업은 어렵다. 자동으로 처리되는 Filter 사용해서 처리한다
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//2) - 계속하는 작업은 어렵다. 자동으로 처리되는 Filter 사용해서 처리한다
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		if(loginDto == null) {
			resp.sendRedirect("./loginServlet.do");	//=>GET으로 요청하면 로그아웃
			return;
		}
		
		// springboot - application.properties
		// 				server.servlet.encoding.charset=UTF-8
		
		//화면에서 <input name="key">의 name 값이다
		String email = req.getParameter("email");
		String password = req.getParameter("password");	// *** Parameter은 절대 null이 될수가 없다. 값이 없다면 ""
		
		log.info("화면에서 요청받은 값 : {}/{}", email, password);
		
		//DTO 생성
		MemberDto inDto = MemberDto.builder()
							.id(loginDto.getId())
							.email(email)
							.password(password)
							.build();
		
		IMemberDao dao = new MemberDaoImpl();
		int cnt = dao.updateUserInfo(inDto);
		
		if(cnt == 1) {	//개인정보를 수정하고 로그아웃 시킨다
			resp.sendRedirect("./loginServlet.do");
		} else {
			resp.getWriter().print("<script>alert('정보 수정 오류!!'); location.href='./loginServlet.do'</script>");
		}
		
	}
	
}










