package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Arrays;

import com.min.edu.comm.Utils;
import com.min.edu.model.AnswerboardDaoImpl;
import com.min.edu.model.IAnswerboardDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/multiDelete.do")
public class MultiDeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5750813820603556300L;
	
	//다중삭제(Delflag) Y로 변경
	//화면에서 여러개의 값을 전송받았으면 어떻게 처리되는가?
	//화면애서 같은 name을 가진 form(input)을 넘겨주면 된다 => request.getParameterValues()
	//요청되는 값 String[] => java.util.List => String framwork에서는 자동으로 객체 및 형변환이 이뤄진다
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("MultiDeleteServlet POST 다중 삭제");
		
		String[] chs = req.getParameterValues("ch");
		IAnswerboardDao dao = new AnswerboardDaoImpl();
		boolean isc = dao.multiDelete(Arrays.asList(chs));
		
		if(isc) {
			resp.sendRedirect("./boardList.do");
		} else {
			Utils.servlet_alert(resp, "서버에 문제가 발생했습니다", "./loginServlet.do");
		}
		
	}

}








