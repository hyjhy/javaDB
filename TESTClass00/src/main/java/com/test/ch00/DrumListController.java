package com.test.ch00;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import com.test.cotroller.DrumList;
import com.test.main.Box;
import com.test.main.Boxdrum;

// 1. webservlet 을 만들어준다. - doGet 을 만든다 - ( Box 로 넘어간다. )
@WebServlet("/drumList")
public class DrumListController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			
		RequestDispatcher rd = 
				req.getRequestDispatcher("/main/drum02.jsp");
		rd.forward(req, resp);
	}
}
