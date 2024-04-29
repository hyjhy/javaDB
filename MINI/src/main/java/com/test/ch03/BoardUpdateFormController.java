package com.test.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ch01.Board;
import com.test.ch02.BoardDao;

@WebServlet("/updateForm")
public class BoardUpdateFormController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String sNo = req.getParameter("no");
		String pass = req.getParameter("pass");
		String pageNum = req.getParameter("pageNum");
		
		if(sNo == null || sNo.equals("") || pass == null || pass.equals("")
				|| pageNum == null || pageNum.equals("")) {
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("	alert('잘못된 접근입니다.');");
			out.println("	history.back();");
			out.println("</script>");
			return;
		}
		
		BoardDao dao = new BoardDao();
		int no = Integer.parseInt(sNo);
		boolean isPassCheck = dao.isPassCheck(no, pass);
		
		if(!isPassCheck) {
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("	alert('비밀번호가 다릅니다.')");
			out.println("	history.back();");
			out.println("</script>");
			return;
		}
		
		// 비밀번호가 맞으면 게시글 내용을 수정 폼에서 출력하기 위해서 BoardDao 객체를 이용해
		// no 에 해당하는 게시들 정보를 읽어온다.
		
		Board board = dao.getBoard(no);
		// 요청을 처리한 결과 데이터를 HttpServletRequest 의 속성에 저장한다.
		req.setAttribute("board", board);
		req.setAttribute("pageNum", pageNum);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/board/updateForm.jsp");
		rd.forward(req, resp);
	}
	

}
