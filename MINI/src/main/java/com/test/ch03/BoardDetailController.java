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

@WebServlet("/boardDetail")
public class BoardDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("no");
		String pageNum = req.getParameter("pageNum");

		if (no == null || no.equals("") || pageNum == null || pageNum.equals("")) {
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("	alert('잘못된 접근입니다.');");
			out.println("	history.back();");
			out.println("</script>");
			return;
		}

		// BoardDao 객체 구하고 게시 글 번호(no)에 해당하는 게시 글을 읽어온다.
		BoardDao dao = new BoardDao();
		Board board = dao.getBoard(Integer.valueOf(no));

		// 요청을 처리한 결과 데이터를 HttpServletRequest의 속성에 저장한다.
		req.setAttribute("board", board);
		req.setAttribute("pageNum", pageNum);

		RequestDispatcher rd = req.getRequestDispatcher("/board/boardDetail.jsp");
		rd.forward(req, resp);
	}

}
