package com.test.ch00;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.cotroller.DrumList;
import com.test.main.Box;

// 1. webservlet 을 만들어준다. - doGet 을 만든다 - ( Box 로 넘어간다. )
@WebServlet("/drum")
public class DrumController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		RequestDispatcher rd = req.getRequestDispatcher("/main/drum01.jsp"); // 불러올 뷰(view)를 입력한다
		rd.forward(req, resp); // 두개의 매개변수를 받는 역할을 한다.
	}
}
