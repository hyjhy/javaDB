package com.jspstudy.bbs.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspstudy.bbs.dao.BoardDao;
import com.jspstudy.bbs.vo.Board;

@WebServlet("/writeProcess")
public class BoardWriteController extends HttpServlet {

	// 서블릿 초기화 메서드를 정의하고 애플리케이션 초기화 파라미터인 uploadDir을 읽어서 파일이 업로드 되는 폴더로 사용할 것임

	private static String uploadDir;
	private static File parentFile;

	@Override
	public void init() {
		// web.xml에 지정한 웹 어플리케이션 초기화 파라미터를 읽는다.
		uploadDir = getServletContext().getInitParameter("uploadDir");

		// 웹 어플리케이션 초기화 파라미터에서 읽어온 파일이 저장될 폴더의 로컬 경로를 구하여 그 경로와 파일명으로 File 객체를 생성한다.

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

		/*
		 * cos 라이브러리를 이용한 파일 업로드 구현하기
		 * 
		 * 1. MultipartRequest의 생성자 매개변수에 지정할 데이터를 설정
		 *
		 * 파일이 저장될 폴더의 로컬 경로를 구한다.
		 **/
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

		/*
		 * 하나의 게시 글 정보를 저장하는 VO(Value Object) 객체를 생성하고 요청 파라미터로 받은 데이터를 Board 객체에 저장한다.
		 **/
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setPass(pass);
		board.setContent(content);

		/*
		 * 사용자가 업로드한 파일 데이터 처리 MultipartRequest 객체를 통해 파일 이름을 구하여 변수에 저장한다. 파일이 업로드 되지
		 * 않으면 fileName은 null 값을 받는다.
		 **/
		String fileName = multi.getFilesystemName("file1");
		System.out.println("업로드 된 파일명 : " + fileName);
		System.out.println("원본 파일명 : " + multi.getOriginalFileName("file1"));

		// 업로드된 파일이 존재하면 파일명이 입력되고 존재하지 않으면 null이 입력된다.
		board.setFile1(fileName);

		if (board.getFile1() == null) {
			System.out.println("파일이 업로드 되지 않았음");
		}

		// BoardDao 객체를 생성해 게시 글을 DB에 추가한다.
		BoardDao dao = new BoardDao();
		dao.insertBoard(board);
		// 페이지 처리 연동
		response.sendRedirect("boardList");
	}
}
