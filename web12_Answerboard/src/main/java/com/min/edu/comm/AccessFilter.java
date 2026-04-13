package com.min.edu.comm;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

//모든 Servlet의 요청 흐름을 제어한다
@WebFilter("/*")
public class AccessFilter implements Filter {
	
	private List<String> excludeURL = List.of();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		//이동 흐름을 요청된 흐름으로 이동시키겠다
		chain.doFilter(request, response);
	}

}
