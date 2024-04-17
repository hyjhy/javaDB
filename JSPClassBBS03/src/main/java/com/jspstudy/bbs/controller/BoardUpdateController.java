package com.jspstudy.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspstudy.bbs.dao.BoardDao;
import com.jspstudy.bbs.vo.Board;

@WebServlet("/updateProcess")
public class BoardUpdateController extends HttpServlet {
	/*
	 * 서블릿 초기화 메서드를 정의하고 애플리케이션 초기화 파라미터인 uploadDir을 읽어서 파일이 업로드 되는 폴더로 사용할 것임
	 **/
	private static String uploadDir;
	private static File parentFile;

	@Override
	public void init() {
		// web.xml에 지정한 웹 어플리케이션 초기화 파라미터를 읽는다.
		uploadDir = getServletContext().getInitParameter("uploadDir");

		/*
		 * 웹 어플리케이션 초기화 파라미터에서 읽어온 파일이 저장될 폴더의 로컬 경로를 구하여 그 경로와 파일명으로 File 객체를 생성한다.
		 **/
		String realPath = getServletContext().getRealPath(uploadDir);
		parentFile = new File(realPath);

		/*
		 * 파일 객체에 지정한 위치에 디렉토리가 존재하지 않거나 파일 객체가 디렉토리가 아니라면 디렉토리를 생성한다.
		 **/
		if (!(parentFile.exists() && parentFile.isDirectory())) {
			parentFile.mkdir();
		}
		System.out.println("init - " + parentFile);
	}

	// post 방식의 요청을 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String contentType = request.getHeader("Content-Type");
		System.out.println("contentType : " + contentType);

		// 요청 파라미터를 저장할 변수 선언
		String pass = null, title = null, writer = null, content = null;
		String sNo = null, pageNum = null, fileNum = null;
		int no = 0;

		// 파일 업로드인지 아닌지 - "multipart/form-data"
		if (contentType.contains("multipart/form-data")) {
			
			// 파일 업로드인 경우
			String realPath = request.getServletContext().getRealPath(uploadDir);

			// 업로드 파일의 최대 크기를 100MB로 지정
			int maxFileSize = 100 * 1024 * 1024;

			// 파일의 인코딩 타입을 UTF-8로 지정
			String encoding = "UTF-8";

			MultipartRequest multi = new MultipartRequest(request, realPath, maxFileSize, encoding,
					new DefaultFileRenamePolicy());
			sNo = multi.getParameter("sNo");
			 title = multi.getParameter("title");
			 writer = multi.getParameter("writer");
			 pass = multi.getParameter("pass");
			 content = multi.getParameter("content");
			 pageNum = multi.getParameter("pageNum");

			String fileName = multi.getFilesystemName("file1");
			System.out.println("업로드 된 파일명 : " + fileName);
			System.out.println("원본 파일명 : " + multi.getOriginalFileName("file1"));

			// 업로드된 파일이 존재하면 파일명이 입력되고 존재하지 않으면 null이 입력된다.
			board.setFile1(fileName);

			if (board.getFile1() == null) {
				System.out.println("파일이 업로드 되지 않았음");
			}
		} else {
			// 파일 업로드가 아닌 경우
			// POST 방식의 요청에 대한 문자 셋 처리
			request.setCharacterEncoding("utf-8"); // 파라미터 형식

			sNo = request.getParameter("no");
			pass = request.getParameter("pass");
			title = request.getParameter("title");
			writer = request.getParameter("writer");
			content = request.getParameter("content");
			pageNum = request.getParameter("pageNum");
		}

		// 정상적인 요청인지 체크

		// BoardDao 객체를 생성하고 게시 글 비밀번호를 체크해 맞지 않으면 이전으로 돌려보낸다.
		BoardDao dao = new BoardDao();
		boolean isPassCheck = dao.isPassCheck(no, pass);

		// 게시 글 번호에 해당하는 게시글 비밀번호가 틀리다면
		if (!isPassCheck) {

			/*
			 * 문자열을 보다 효율적으로 다루기 위해서 StringBuilder 객체를 이용해 응답 데이터를 작성하고 있다. 아래에서는 비밀번호가 틀리면
			 * 사용자에게 경고 창을 띄우고 브라우저의 history 객체를 이용해 바로 이전으로 돌려보내기 위해서 자바스크립트로 응답을 작성하고 있다.
			 **/
			StringBuilder sb = new StringBuilder();
			sb.append("<script>");
			sb.append("	alert('비밀번호가 맞지 않습니다.');");
			sb.append("	history.back();");
			sb.append("</script>");

			/*
			 * 응답 객체에 연결된 JspWriter 객체를 이용해 응답 데이터를 전송하고 더 이상 실행할 필요가 없으므로 return 문을 이용해 현재
			 * 메서드를 종료한다.
			 **/
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(sb.toString());
			System.out.println("비밀번호 맞지 않음");
			return;
		}

		// 비밀번호가 맞으면 사용자가 게시 글 수정 폼에 입력한 데이터를 읽어온다.
		title = request.getParameter("title");
		writer = request.getParameter("writer");
		content = request.getParameter("content");
		
		

		/*
		 * 하나의 게시 글 정보를 저장하는 자바빈 객체를 생성하고 파라미터로 넘겨받은 요청 데이터를 Board 객체에 저장한다.
		 **/
		Board board = new Board();
		board.setNo(no);
		board.setTitle(title);
		board.setWriter(writer);
		board.setPass(pass);
		board.setContent(content);

		
		no = Integer.parseInt(sNo);
		
		// BoardDao의 updateBoard() 메서드를 이용해 DB에서 게시 글을 수정한다.
		dao.updateBoard(board);
		

		
		response.sendRedirect("boardList?pageNum="+pageNum);
	}
}
