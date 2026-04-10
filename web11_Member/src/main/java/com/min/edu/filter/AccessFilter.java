package com.min.edu.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.min.edu.dto.MemberDto;

/*
 * TODO 113 WAS로 요청되는 모든 요청을 가로채기 하여 인코딩을 설정, 로그인된 정보를 확인
 * 		Servlet의 생명주기(초기화(init) - 서비스 실행(service) - 종료(destory))
 * 		 ㄴ 수정하거나 변경하실 수 없다. 즉, 무조건 life-cycle에 맞춰서 작업을 해야한다
 * 		 ㄴ life-cycle <=> POJO 개발
 * 
 * 		Servlet이 뭔가요? 설명해보세요
 * 		- URL Mapping : 화면의 요청은 JAVA의 HttpServlet 클래스와 연결 @WebServlet, @RequestMapping
 * 		- hierarchy : HttpServlet => ServletRequest, ServletResponse => HttpServletRequest, HTTPServletResponse
 * 		- life-cycle : life-cycle에 맞춰서 작업을 해야한다
 */
@WebFilter("/*")
public class AccessFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1054009085237946674L;
	
	private List<String> excludeURL = Arrays.asList(
			"/loginServlet.do",		//로그인 요청은 filter에서 제외, 세션을 담는 기능을 가지고 있기 때문에
			"/registServlet.do",	//회원가입 화면은 로그인없이 진행한다
			"/js/regist.js", "/css/comm.css"	//사용하는 이미지, js파일, 기타 등등을 모두 제외해줘야 화면에서 읽어낼 수 있다
			);

	public AccessFilter() {
    }


	public void destroy() {
		System.out.println("^^->> Filter 나감");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("^^ Filter 통과");
		
		//요청/응답 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		HttpServletRequest req = (HttpServletRequest) request;
		// 요청 주소
		String pathURL = req.getServletPath();
		if (!excludeURL.contains(pathURL)) {
			//로그인 상태 확인
			HttpSession session = req.getSession();
			MemberDto loginDto = (MemberDto) session.getAttribute("loginDto");
			System.out.println("현재 접속된 로그인 정보 :" + loginDto);
			if (loginDto == null) {
				//로그인 된 상태가 없다면 로그인 페이지로(index.jsp)
				req.getRequestDispatcher("./").forward(request, response);
				return;
			} 
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("^^<<- Filter 들어옴");
	}

}
