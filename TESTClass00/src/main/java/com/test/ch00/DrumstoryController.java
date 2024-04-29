package com.test.ch00;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.cotroller.DrumList;
import com.test.main.Box;

// 1. webservlet 을 만들어준다. - doGet 을 만든다 - ( Box 로 넘어간다. )
@WebServlet("/drumProcess")
public class DrumstoryController extends HttpServlet {
	
	private static String uploadDir;
	private static File parentFile;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
String realPath = req.getServletContext().getRealPath(uploadDir);
		
		// 업로드 파일의 최대 크기를 100MB로 지정
		int maxFileSize = 100 * 1024 * 1024;
		
		// 파일의 인코딩 타입을 UTF-8로 지정
		String encoding = "UTF-8"; 

		MultipartRequest multi = new MultipartRequest(req, realPath, 
					maxFileSize, encoding, new DefaultFileRenamePolicy());	
		
		/* 사용자가 폼에 입력한 데이터 처리
		 * MultipartRequest 객체를 통해 파라미터를 읽어 변수에 저장한다. 
		 **/	
		String no = multi.getParameter("no");
		String name = multi.getParameter("name");
		String sum = multi.getParameter("sum");
		String number = multi.getParameter("number");		
		String brand = multi.getParameter("brand");		
		String memo = multi.getParameter("memo");		
		
		/* 하나의 게시 글 정보를 저장하는 VO(Value Object) 객체를 생성하고
		 * 요청 파라미터로 받은 데이터를 Board 객체에 저장한다.
		 **/
		DrumList board = new DrumList(); // DB 객체를 생성하는 java 매서드 입력하기 
		board.setNo(0);
		board.setName("name");
		board.setSum("sum");
		board.setNumber("number");
		board.setBrand("brand");
		board.setMemo("memo");
		/* 사용자가 업로드한 파일 데이터 처리
		 * MultipartRequest 객체를 통해 파일 이름을 구하여 변수에 저장한다.
		 * 파일이 업로드 되지 않으면 fileName은 null 값을 받는다.
		 **/
		
		String fileName = multi.getFilesystemName("file");
		System.out.println("업로드 된 파일명 : " + fileName);
		System.out.println("원본 파일명 : " + multi.getOriginalFileName("file"));
		
		// 업로드된 파일이 존재하면 파일명이 입력되고 존재하지 않으면 null이 입력된다.	 
		board.setFile(fileName);
		
		if(board.getFile() == null) {		
			System.out.println("파일이 업로드 되지 않았음");		
		}	
		
		// Box 객체를 생성해 게시 글을 DB에 추가한다.
		Box dao = new Box();
		dao.insertDrum(board);
		
		resp.sendRedirect("boardList");
	}
}
