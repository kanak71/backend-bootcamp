package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

//TODO 017 사용자 권한 변경 Servlet 작성
@Slf4j
@WebServlet("/authUpdateServlet.do")
public class AuthupdateServlet extends HttpServlet {

	private static final long serialVersionUID = -4838667740538978539L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("AuthupdateServlet POST 회원 권한 변경");
		
		String id = req.getParameter("id");
		log.info("권한 변경 요청 아이디 : {}", id);
		
		IMemberDao dao = new MemberDaoImpl();
		MemberDto dto = dao.getUserInfo(id);
		
		//현재권한 조회
		String currentAuth = dto.getAuth();
		String newAuth = "ROLE_USER".equals(currentAuth) ? "ROLE_ADMIN":"ROLE_USER";
		
		Map<String, Object> map = new HashMap<String, Object>(){{
			put("id", id);
			put("auth", newAuth);
		}};
		
		int cnt = dao.updateAuthUser(map);
		
		// 처리 결과에 따라 JSON으로 만들어서 값을 전송
		//{"success":true, "newAuth": ""}
		//{"success":false}
		if(cnt == 1) {
			resp.getWriter().write("{\"success\":true, \"newAuth\": \""+newAuth+"\"}");
		} else {
			resp.getWriter().write("{\"success\":false}");
		}
		
		resp.getWriter().flush();

	}
	
	//GET 요청시 커스터마이징 코드를 작성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST 방식만 지원합니다");
	}

}




