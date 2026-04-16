package com.min.edu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

//TODO 003 파일업로드 처리를 위한 Servlet
@WebServlet("/upload.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 100
		)


public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1425952894614511580L;
	
	private static final String UPLOAD_DIR = "uploads";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전달받은 text의 내용
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println("전달받은 form 필드의 text 값");
		System.out.println(title + "/" + content);
		
		//1) 파일이 물리적으로 저장 + 파일명
		// 파일경로- 저장되는 경로를 지정 및 생성 (상대경로-서버, 절대경로-ftp,c:\)
		String uploadPath = getServletContext().getRealPath("")+UPLOAD_DIR;
		System.out.println("서버에 파일을 저장할 경로");
		System.out.println(uploadPath);
		
		//파일경로가 없으면 만들기
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();	//mkdir은 폴더를 만드는 명령어, mkdirs는 필요한 모든 상위 폴더도 같이 만듦
		}
		
		//파일업로드 목록 저장하는 객체
		List<String> uploadedFiles= new ArrayList<String>();
		
		//2) 파일은 multipart에서 가져와서 "데이터"를 저장 (010101 byte코드)
		// request.getParts()는 클라이언트에서 전송한 모든 multipart 항목을 가져옴(폼필드 + 데이터)
		for (Part part: req.getParts()) {
			//업로드된 파일의 실제 이름을 가져온다
			String fileName = part.getSubmittedFileName();	//오직 <input type="file>에만 적용
			
			//업로드된 파일의 유효성 검사
			if(fileName != null && !fileName.isEmpty()) {
				//서버에 파일을 저장
				part.write(uploadPath+File.separator+fileName);	//inputStream -> FileOutStream 처리 한다
				uploadedFiles.add(fileName);
				
			}
		}
		
		System.out.println("업로드 된 파일 목록");
		System.out.println(uploadedFiles);
		
		//JSP에 목록을 보여주기 위해서 request 요청
		req.setAttribute("fileList", uploadedFiles);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		
	}

}








