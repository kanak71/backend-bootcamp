package com.min.edu.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{

	private static final long serialVersionUID = 6285464148513456713L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("테스트 GET 전달값 , 요청 postman");
		String postMan = req.getParameter("postman");
		System.out.println("전달받은 요청값 postman: "+ postMan);
		
		String coffee = req.getParameter("coffee");
		System.out.println("선택된 커피의 종류:"+coffee);
		
		String type = req.getParameter("beanType");
		System.out.println("커피의 타입 : "+ type);
		
		String bags = req.getParameter("bags");
		if(bags == null) {
			bags = "0";
		}
		int bagsNum = Integer.parseInt(bags);
		System.out.println((bagsNum*10) +" 잔");
		
		String[] extras =req.getParameterValues("extra");
		if(extras != null) {
			for(String extra : extras) {
				System.out.println(extra);
			}
		}
		
		String comment = req.getParameter("comment");
		System.out.println(comment);
		
	}
}
