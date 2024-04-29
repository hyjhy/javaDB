package com.test.ch03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ch01.Board;
import com.test.ch02.BoardDao;

@WebServlet("/boardList")
public class BoardListController extends HttpServlet{

	private static final int PAGE_SIZE = 10;
	
	private static final int PAGE_GROUP = 10;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pageNum = req.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = currentPage * PAGE_SIZE - (PAGE_SIZE -1);
		
		int endRow = startRow + PAGE_SIZE - 1;
		
		BoardDao dao = new BoardDao();
		
		int listCount = dao.getBoardCount();
		ArrayList<Board>bList = dao.boardList(startRow, endRow);
		
		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		int startPage = currentPage / PAGE_GROUP * PAGE_GROUP + 1 - (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		
		int endPage = startPage + PAGE_GROUP - 1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		req.setAttribute("bList", bList);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageGroup", PAGE_GROUP);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		
		RequestDispatcher rd = req.getRequestDispatcher("/board/boardList.jsp");
		rd.forward(req, resp);
	} // end doGet
	
	 
} // end class
