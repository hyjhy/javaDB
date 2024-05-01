package com.test.ch03;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/updateProcess")
public class BoardUpdateController extends HttpServlet {

	private static String uploaDir;
	private static File parentFile;

	@Override
	public void init() {
		uploaDir = getServletContext().getInitParameter("uploadDir");

		String realPath = getServletContext().getRealPath(uploaDir);
		parentFile = new File(realPath);

		if (!(parentFile.exists() && parentFile.isDirectory())) {
			parentFile.mkdir();
		}
		System.out.println("init - " + parentFile);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String contentType = req.getHeader("Content-Type");
		System.out.println("contentType : " + contentType);
		// 요청 파라미터를 저장할 변수 선언
		String pass = null, title = null, name = null;
		String sNo = null, pageNum = null, fileName = null;
		int no = 0;
		// 파일 업로드인지 아닌지
		if (contentType.contains("multipart/form-data")) {
			// 파일 업로드인 경우
			String realPath = req.getServletContext().getRealPath(uploaDir);
			int maxFileSize = 100 * 1024 * 1024;
			String encoding = "utf-8";

			MultipartRequest multi = new MultipartRequest(req, realPath, maxFileSize, encoding,
					new DefaultFileRenamePolicy());

			sNo = multi.getParameter("no");
			title = multi.getParameter("title");
			name = multi.getParameter("name");
			pass = multi.getParameter("pass");
			pageNum = multi.getParameter("pageNum");

			fileName = multi.getFilesystemName("file1");
			System.out.println("업로드 된 파일명 : " + fileName);
			System.out.println("원본 파일명 : " + multi.getOriginalFileName("file1"));
			System.out.println(name);
			if (fileName == null) {
				System.out.println("파일이 업로드 되지 않았습니다.");
			}
		} else {
			// 파일 업로드가 아닌 경우
			req.setCharacterEncoding("utf-8");

			sNo = req.getParameter("no");
			pass = req.getParameter("pass");
			title = req.getParameter("title");
			name = req.getParameter("name");
			pageNum = req.getParameter("pageNum");
		}
		
		// 정상적인 요청인지 체크
		if (sNo == null || sNo.equals("") || pass == null || pass.equals("") || pageNum == null || pageNum.equals("")) {
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();	
			out.print("<script>");
			out.print("	alert('잘못된 접근입니다.');");
			out.print("	history.back();");
			out.print("</script>");
			return;
		}

		no = Integer.parseInt(sNo);
		// BoardDao 객체를 생성하고 게시글 비밀번호를 체크해 맞지 않으면 이전으로 돌려보낸다.
		BoardDao dao = new BoardDao();
		boolean isPassCheck = dao.isPassCheck(no, pass);

		// 게시글 번호에 해당하는 게시글 비밀번호가 틀리다면
		if (!isPassCheck) {
			StringBuilder sb = new StringBuilder();
			sb.append("<script>");
			sb.append("	alert('비밀번호가 맞지 않습니다.');");
			sb.append("	history.back();");
			sb.append("</script>");

			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(sb.toString());
			System.out.println("비밀번호가 맞지 않습니다.");
			return;
		}
		// 넘겨받은 요청 데이터를 Board 객체레 저장한다.
		Board board = new Board();
		board.setNo(no);
		board.setTitle(title);
		board.setName(name);
		board.setPass(pass);
		board.setFile1(fileName);

		// BoardDao의 updateBoard() 메서드를 이용해 DB 에서 게시글을 수정한다.
		dao.updateBoard(board);

		resp.sendRedirect("boardList?pageNum=" + pageNum);
	}
}