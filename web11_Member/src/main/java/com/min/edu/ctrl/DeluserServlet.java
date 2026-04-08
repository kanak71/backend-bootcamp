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

//TODO 012 사용자 삭제 Servlet 작성
@Slf4j	//AOP
@WebServlet("/delUserServlet.do")
public class DeluserServlet extends HttpServlet {
	

	private static final long serialVersionUID = -5608574497127547859L;

	//id를 가지고 삭제(enable='N', update)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DeluserServlet GET 사용자 삭제(회원탈퇴)");
		
		MemberDto loginDto = (MemberDto)req.getSession().getAttribute("loginDto");
		req.getSession().invalidate();
		
		IMemberDao dao = new MemberDaoImpl();
		int cnt = dao.delUser(loginDto.getId());
		
		if(cnt==1) {
			resp.sendRedirect("./"); 	//index.jsp(로그인페이지)를 호출
		}else {
			//error 페이지가 보안영역인(/WEB-INF)에 위치한다면 HttpServletRequest로 요청
			//				일반영역(webapp/*)에 위치한다면 HttpServletResponse로도 요청 가능
			// 현재는 "/WEB-INF/"에 작성할 예정이기 때문에 request를 통한 요청만 허용
			req.getRequestDispatcher("/WEB-INF/views/err/error.html").forward(req, resp);
		}
		
		
	}
	
}
