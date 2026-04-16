package com.min.edu.comm;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;

// 반복되는 요청인 
// 화면에 script alert을 처리해주는 기능을 정의
// HttpServletResponse, String url
public class Utils {

	public static void servlet_alert(HttpServletResponse resp, String msg, String url) throws IOException {
		
		PrintWriter out = resp.getWriter();
		
		out.print("<script>");
		out.print("alert('"+msg+"');");
		out.print("location.href='"+url+"';");
		out.print("</script>");
		out.flush();
	}
}















