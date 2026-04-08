package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

// TODO 009 로그인, 로그아웃 Servlet 작성
@Slf4j
@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//로그아웃
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("LoginServlet GET 로그아웃");
		// 로그인되어 있는 정보를 삭제해준다 => Session Scope를 삭제해 준다
		HttpSession session = request.getSession();	//DI
		session.invalidate();	//session객체에 있는 모든 값을 삭제(session객체 자체를 삭제)
		// 내가 특정한 session의 값만을 삭제 하고 싶다. key를 가지고 삭제해주면 된다. ex)페이징, 장바구니..
		//session.removeAttribute("loginDto");
		
		//request/response 객체를 가지고 가지 않는다. 새로운 페이지를 부른다
		response.sendRedirect("./");	//=> index.jsp를 호출하겠다
	}

	//로그인
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("LoginServlet POST 로그인");
		// 인코딩, UTF-8 문자 인코딩을 사용하고 있다. 화면(클라이언트) -> 서버, 서버 -> 화면(클라이언트) 로 값이 전송될 때,
		// 사용되고 있는 인코딩을 선언해서 읽어 주고 보내줘야한다
		// HttpServletRequest request 모든 요청에 대한 객체 : 값을 보내주거나, 값을 받아주거나
		// HttpServletResponse response 모든 응답에 대한 객체
		
		request.setCharacterEncoding("UTF-8");	//화면(클라이언트) -> 서버로 전달되는 데이터의 문자 인코딩을 UTF-8, 사용자가 입력한 값의 인코딩을 UTF-8로 하겠다
		response.setContentType("text/html; charset=UTF-8"); //서버->브라우저로 보내는 데이터의 인코딩을 UTF-8, 
		
		//작성순서
		//1) 화면의 요청값 request.getParameter("id"), <form>요소의 <input name="값">
		//2) DAO에 요청하는 형태의 객체로 변경 Map<String, Object>
		//3) Dao(MemberDaoImpl-getLogin)를 실행
		//4) 결과 값을 session scope에 담아 준다
		//5) 로그인 후 화면으로 이동 request.getRequestDisoatcher("/WEB-INF/views/userMain.jsp").forward(request,response);
		
		//1) 
		String id = request.getParameter("id");
		String name = request.getParameter("pw");
		//2)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", name);
		log.info("전달받은 요청값: {}", map);
		//3) 
		IMemberDao dao = new MemberDaoImpl();
		MemberDto loginDto = dao.getLogin(map);
		log.info("로그인된 사용자 정보 : {}", loginDto);
		
		//selectOne 했기 때문에 없는 경우(공집합) null로 변경
		if(loginDto != null) {
			
			//4) Session Scope
			//JSESSIONID 값을 담아서 처리해준다. 브라우저가
			HttpSession session = request.getSession();
			session.setAttribute("loginDto", loginDto);
			//session 관리를 위한 메소드가 있다
			//일정한 시간 동안 활동이 없으면 자동으로 session 삭제
			session.setMaxInactiveInterval(20*60);	//20분동안 활동이 없으면 session삭제
			
			//5) 흐름제어
			//RequestDispatcher 객체, request값과 이동흐름(URL)을 같이 이동 시켜 준다
			//WEB-INF폴더 : 보안영역, 외부에서 주소를 통해서 접근할 수 없고, 반드시 서버(HttpServlet)를 통해서 접근이 가능한 곳
			request.getRequestDispatcher("/WEB-INF/views/userMain.jsp").forward(request, response);
			
		} else {
			//로그인이 실패했을 경우
			response.getWriter().print("<script>alert('회원정보가 없습니다'); location.href='./'</script>");
			
		}
	}

}
