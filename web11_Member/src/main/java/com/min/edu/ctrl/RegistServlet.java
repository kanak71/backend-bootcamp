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
import lombok.extern.slf4j.Slf4j;

//TODO 013 회원가입(사용자 입력) Servlet 작성
@Slf4j
@WebServlet("/registServlet.do")
public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = -7839115776527726264L;
	
	//회원가입 정보를 입력하는 (form) 화면으로 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RegistServlet GET 회원가입 화면 이동 form");
		// 화면만을 이동할때는 response.sendRedirect(url) 사용하면 되지만,
		// 현재 페이지가 보안 영역인 "/WEB-INF/"에 있다 따라서 RequestDispatcher로 작동 시켜야한다
		req.getRequestDispatcher("/WEB-INF/views/registForm.jsp").forward(req, resp);
		
	}
	
	//회원가입 정보를 입력받아 DB에 저장
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RegistServlet POST 회원가입 정보 입력");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//MemberDTO와 매핑된 getter/setter의 명 id, name, password, email
		//화면의 name명
		//*Spring에서는 자동으로 객체를 생성해서 바인딩 해주기 때문에 parameter를 받을 필요가 없음
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		MemberDto dto = MemberDto.builder()
							.id(id)
							.name(name)
							.password(password)
							.email(email)
							.build();
		
		IMemberDao dao = new MemberDaoImpl();
		int cnt = dao.insertUser(dto);
		
		if(cnt == 1) {
			// sendRedirect가 가능한 이유는 index.jsp(로그인) 페이지가 webapp에 생성되어 있어서 주소로 접근가능한 위치
			resp.sendRedirect("./");
			
		}else {
			//회원가입 Servlet을 호출
			resp.sendRedirect("./registServlet.do");
			
		}
	}

}
