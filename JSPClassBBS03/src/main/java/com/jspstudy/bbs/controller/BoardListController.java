package com.jspstudy.bbs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspstudy.bbs.dao.BoardDao;
import com.jspstudy.bbs.vo.Board;

@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	
	private static final int PAGE_SIZE = 10;
	
	private static final int PAGE_GROUP = 10;

	// get 방식의 요청을 처리하는 메소드
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		// 입력 처리
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		
		// 1P * 10 = 10
		int startRow = currentPage * PAGE_SIZE - (PAGE_SIZE - 1 );
		
		int endRow = startRow + PAGE_SIZE - 1;
		
		
		
		// BoardDao 객체를 생성하고 데이터베이스에서 게시 글 리스트를 읽어온다.
		BoardDao dao = new BoardDao();
		
		// 전체 게시글 수
		int listCount = dao.getBoardCount();
		ArrayList<Board> bList = dao.boardList(startRow, endRow);
		
		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		int startPage = currentPage / PAGE_GROUP * PAGE_GROUP +1 - (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		
		int endPage = startPage + PAGE_GROUP - 1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
				
		

		// 요청을 처리한 결과 데이터를 HttpServletRequest의 속성에 저장한다. / 저장소에 저장 보내줄 정보를 입력한다.
		request.setAttribute("bList", bList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageGroup", PAGE_GROUP);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		/* view 페이지로 제어를 이동해 요청에 대한 결과를 출력하기 위해
		 * HttpServletRequest 객체로 부터 RequestDispatcher 객체를 구하고
		 * /WEB-INF/board/boardList.jsp 페이지로 포워딩 한다. 
		 **/
		RequestDispatcher rd = 
				request.getRequestDispatcher("/WEB-INF/board/boardList.jsp");
		rd.forward(request, response);
	}
}
