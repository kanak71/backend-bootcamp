package com.min.edu.comm;

import java.io.IOException;
import java.util.List;

import com.min.edu.dto.MemberDto;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// 모든 Servlet의 요청 흐름을 제어한다
@WebFilter("/*")
public class AccessFilter implements Filter {

	//로그인 페이지, 로그인 처리 Servlet은 제외한다
	private List<String> excludeURL = List.of("/loginServlet.do", "/img/reply.png");
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//모든 이동흐름을 가로채서 Encoding 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		//ServletRequest -> 다운캐스팅 하여 HttpServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		
		//로그인된 Session을 확인
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		
		//myBatis에서 로그인의 값을 처리 하기 위해서 selectOne()으로 처리했다. 따라서 null로 체크해야 한다
		//								만약에 selectList()으로 처리했다면, List로 반환되기 때문에 size 판단해야 한다
		//만약에 객체 없이 get... 메소드를 호출하면 NullPointException이 발생한다
		if(!excludeURL.contains(req.getServletPath())) {
			if(loginDto == null) {
				req.getRequestDispatcher("/WEB-INF/views/loginForm.jsp").forward(request, response);
			}
		}
		
		
		//이동 흐름을 요청된 흐름으로 이동시키겠다
		chain.doFilter(request, response);
	}

}





