package com.test.ch03;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.ch01.Board;
import com.test.ch02.BoardDao;

@WebServlet("/writeProcess")
public class BoardWriteController extends HttpServlet {

	private static String uploaDir;
	private static File parentFile;
	
	@Override
	public void init() {
		uploaDir = getServletContext().getInitParameter("uploadDir");
		
		String  realPath = getServletContext().getRealPath(uploaDir);
		parentFile = new File(realPath);
		
		if(! (parentFile.exists() && parentFile.isDirectory())) {
			parentFile.mkdir();
		}
		System.out.println("init - " + parentFile);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String realPath = req.getServletContext().getRealPath(uploaDir);

		int maxFileSize = 100 * 1024 * 1024;

		String encoding = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(req, realPath,
				maxFileSize, encoding, new DefaultFileRenamePolicy());

		String title = multi.getParameter("title");
		String name = multi.getParameter("name");
		String pass = multi.getParameter("pass");
		


		Board board = new Board();
		board.setTitle(title);
		board.setName(name);
		board.setPass(pass);
		

		BoardDao dao = new BoardDao(); // 게시글을 DB에 추가한다.
		dao.insertBoard(board);
		
		

		resp.sendRedirect("boardList");
	}
}