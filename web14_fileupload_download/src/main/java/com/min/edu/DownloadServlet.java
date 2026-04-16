package com.min.edu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;

//TODO 004 파일 다운로드 Servlet
@WebServlet("/download.do")
public class DownloadServlet extends HttpServlet {

	
	private static final long serialVersionUID = -7014296362594597846L;
	
	private static final String UPLOAD_DIR = "uploads";

	//1)요청받은 파일이름과 + 파일의 위치
	//2)브라우저에게 지금 보내는 데이터를 HTML도 아니고, TEXT도 아니고, "데이터이다" => 브라우저는 다운로드를 실행
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1) 요청 파일명을 받아줌
		String fileName = req.getParameter("filename");
		//2) 위치 + 파일명으로 실제적으로 데이터가 있는 곳의 위치를 지정
		// File.separator는 폴더표시(enter위에키) windows:\ , linux:/
		String filePath = getServletContext().getRealPath("")+UPLOAD_DIR+File.separator+fileName;
		System.out.println("요청 다운로드 파일의 경로");
		System.out.println(filePath);
		
		//파일의 경로 문자열을 통해서 File 객체로 사용한다
		File file = new File(filePath);
		
		if(file.exists()) {
			String encodedFileName = URLEncoder.encode(fileName, "UTF-8");
			
			
			//브라우저에게 파일을 보낼 때 "바이너리파일이고, 다운로드 해야한다"고 알려줘야 한다
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment;filename="+encodedFileName);
			
			//파일을 읽고 OutPutStream
			//try-with-resource : try(객체) 자동으로 완료되면 해당 객체를 닫아(close) 해준다
			//try{객체}catch(){}finally{객체.close()}
			try(
				FileInputStream in = new FileInputStream(file);	//물리적인 곳에서 파일을 0101(바이너리) 코드로 읽어옴
				OutputStream out = resp.getOutputStream();	//응답객체(HttpServletResponse)에 데이터(바이너리)를 보내줌 
				){
				
				byte[] buffer = new byte[4096];
				int length;	//읽은 변수를 저장해서 OutputStream 해주기 위한 변수
				while((length = in.read(buffer)) >0) {	//파일을 읽고 끝이라면 -1을 반환
					out.write(buffer, 0, length);
					
				}
			}
		} else {
			resp.getWriter().print("파일을 챶을 수 없습니다");
		}
	}
}





