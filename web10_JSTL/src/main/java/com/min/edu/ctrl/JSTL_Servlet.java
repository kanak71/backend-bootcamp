package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.min.edu.dto.ScoreDto;

//TODO 004 화면의 요청을 처리하는 Controller
// @Controller가 된다
@WebServlet("/jstl.do")
public class JSTL_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JSTL_Servlet GET 요청 처리");
		
		//MIME Type : 요청과 응답시 처리되는 문자의 처리 방식 => text/html; charset=UTF-8
		//			 ㄴ 문자로 전송, HTML문법으로 읽고, 문자의 문자표는 UTF-8로 작성되어 있다
		response.setContentType("text/html; charset=UTF-8");
		
		//service -> dao(repository) -> DB -> 결과값을 dao -> service -> controller -> 객체로 만들어서 -> JSP-> JSTL 처리
		List<ScoreDto> lists = new ArrayList<ScoreDto>();
		for(int i=0; i<10; i++) {
			ScoreDto tmp = new ScoreDto("홍길동" + i, i+10, i+20, i+30, "Hong");
			lists.add(tmp);
		}
		
		//화면에 값을 보내기 위한 request에 값을 담아 준다
		//scope : 	request - 서버로부터 전달받은 값 ex)lists
		//			session - 서버에서 값을 가지고 있는 값 ex)로그인 정보
		//			application - 서버에서 값을 유지하고 있다
		//
		request.setAttribute("lists", lists);
		
		
		//이동할 곳을 지정해준다
		//객체를 담고 있는 request/response 객체를 같이 가지고 간다
		//pass by reference
		request.getRequestDispatcher("/WEB-INF/view/jstlPage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
