package com.min.edu.ctrl;

import java.io.IOException;

import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

//TODO 014 사용자의 아이디 중복 검사 Servlet 작성
@Slf4j
@WebServlet("/duplicateIdServlet.do")
public class DuplicateidServlet extends HttpServlet {


	private static final long serialVersionUID = 4283235445121673609L;
	
	//GET과 POST의 요청이 모두 들어 올 수 있다
	//하지만 처리는 두 번 작성하면 재활용성이 떨어지기 때문에 모든 요청 처리해 주는 메소드를 만들어 준다
	
	//주소를 통해서 ID값을 전달받아 요청 할 때
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		checkDuplicate(req,resp);
	}
	
	//body(form)을 통해서 ID값을 전달받아 요청 할 때
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		checkDuplicate(req,resp);
	}
	
	//GET과 POST를 모두 처리해주는 내부 메소드
	private void checkDuplicate(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		//AJX 비동기식 처리 방법, fetch, axios, Jquery Ajax
		//HTML 반환했지만 Ajax는 값(기본타입-String => JSON {"key""value"}) => Map을 반환하게 된다
		//simple-json,Gson, jackson-bind : 자동으로 자바의 객체를 Json으로 변경해 주는 라이브러리
		
		String id = req.getParameter("id");
		log.info("중복 검사 요청 아이디 : {}", id);
		
		IMemberDao dao = new MemberDaoImpl();
		String checkId = dao.duplidateId(id);
		
		//selectOne으로 처리 했기 때문에 SQL결과가 없으면 공집합 => myBatis null이다
		boolean isUse = (checkId == null); 	//true면 사용할 수 있다
		
		//JSON 문자열로 작성해서 보내준다 = {"Key":"value"}
		resp.getWriter().write("{\"available\" : "+isUse+"}");
		resp.getWriter().flush();
		
	}
	
	
}
