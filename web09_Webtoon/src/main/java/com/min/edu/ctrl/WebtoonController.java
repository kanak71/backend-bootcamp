package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet("/webtoon.do")
public class WebtoonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("화면에서 GET요청이 들어 왔다 (❁´◡`❁)");
		
		//1) 화면에서의 요청을 java의 객체로 받아 준다(화면에서의 name을 키로 사용)
		String webtoonNumber = request.getParameter("title");
		System.out.println("요청값은 Paramter의 값 :" + webtoonNumber);

		//2) 만화 이미지를 담기 위한 List 생성
		List<Object> imgList = new ArrayList<Object>();
		
		//3) jsoup을 통해서 url을 요청하고, 받은 HTML을 DOM탐색을 하여 필요한 정보를 추출
		String url = "https://comic.naver.com/webtoon/detail?titleId="+webtoonNumber+"&no=1";
		Document doc =  Jsoup.connect(url).get();
		Elements ele = doc.select("#comic_view_area");
		Elements eleImg = ele.select("div>img"); // 여러개 담겨 HTMLCollection
		
		for (Element element : eleImg) {
			imgList.add(element);
		}
		
		for (Object obj: imgList) {
			System.out.println(obj);
		}
		
		
		// 화면에 뿌려진 값을 request 객체를 통해서 화면에 보내 주면 된다 => JSP => HTML만들어서 WS 보내준다
		request.setAttribute("wList", imgList);
		// 보낼 파일(JSP)에 붙여줌
		request.getRequestDispatcher("/WEB-INF/webtoon.jsp").forward(request, response);
		
		
	} // GET요청

} //class
