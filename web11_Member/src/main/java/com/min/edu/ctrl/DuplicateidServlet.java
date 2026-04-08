package com.min.edu.ctrl;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO 014 사용자의 아이디 중복 검사 Servlet 작성
public class DuplicateidServlet extends HttpServlet {


	private static final long serialVersionUID = 4283235445121673609L;
	
	//GET과 POST의 요청이 모두 들어 올 수 있다
	//하지만 처리는 두 번 작성하면 재활용성이 떨어지기 때문에 모든 요청 처리해 주는 메소드를 만들어 준다
	
	//주소를 통해서 ID값을 전달받아 요청 할 때
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	//body(form)을 통해서 ID값을 전달받아 요청 할 때
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	//GET과 POST를 모두 처리해주는 내부 메소드
	private void checkDuplicate(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
	}
	
	
}
