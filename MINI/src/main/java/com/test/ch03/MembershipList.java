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
import com.test.ch01.Information;
import com.test.ch02.BoardDao;

@WebServlet("/membershipList")
public class MembershipList extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");

		String name = req.getParameter("name");
		System.out.println(name);
		String email1 = req.getParameter("email1");
		String member = req.getParameter("member");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		Information mation = new Information();
		mation.setName(name);
		mation.setEmail1(email1);
		mation.setMember(member);
		mation.setId(id);
		mation.setPass(pass);

		BoardDao dao = new BoardDao(); // 게시글을 DB에 추가한다.
		dao.insertMation(mation);

	}
}