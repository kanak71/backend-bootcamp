package com.min.edu.ctrl;

import java.io.IOException;

import com.min.edu.comm.Utils;
import com.min.edu.dto.MemberDto;
import com.min.edu.model.AnswerboardDaoImpl;
import com.min.edu.model.IAnswerboardDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/realDelete.do")
public class DeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6515897282490941510L;
	
	//글 완전삭제(DB삭제)
	//권한이 관리자인 계정에 대해서만 삭제를 진행
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DeleteServlet GET 완전삭제");
		
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		
		if(!loginDto.getAuth().equalsIgnoreCase("ROLE_ADMIN")) {
			Utils.servlet_alert(resp, "삭제 권한이 없습니다", "./loginServlet.do");
		} else {
			String seq = req.getParameter("seq");
			IAnswerboardDao dao = new AnswerboardDaoImpl();
			boolean isc = dao.deleteBoard(seq);
			if(isc) {
				resp.sendRedirect("./boardList.do");
			}else {
				resp.sendRedirect("./detailBoard.do?seq="+seq);
			}
		}
	}

}
