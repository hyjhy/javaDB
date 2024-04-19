package com.test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.cotroller.DrumList;

public class Box {
	// 1. JDBC DB 프로그램에 필요한 객체
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	// 2. public Box 를 만들어준다. - 현재 매서드랑 같은 이름으로 만들어준다.
	public Box() {
		// 5. ds null 값을 해결해주는 곳
		try {
			// 5-1 JNDI DBCP 사용하기 위한 기준 객체 생성
			Context initContext = new InitialContext(); // 생성만 먼저 적어주면 try , catch 를 자동으로 생성할 수 있다.
			// java:/comp/env 절대적인 값이다.
			Context envContext = (Context) initContext.lookup("java:/comp/env");

			ds = (DataSource) envContext.lookup("jdbc/bbsDBPool");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 6.
	public void insertDrum(Boxdrum box) {
		String sqlInset = "insert into drum values\r\n"
				+ "(no, name, sum, number, brand)";
	
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sqlInset);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	

	// 3.
	public List<DrumList> boardList() {
		String sqlBoardList = "select * from drum order by no desc";
		List<DrumList> bList = null;

		try {
			// 3-1 DB 연결
			conn = ds.getConnection(); // # conn = ds.getConnection() 을 입력하면 자동으로 try , catch 를 생성할 수 있습니다.
			// 3-2 DB 에 SQL 쿼리를 발행 해주는 객체
			pstmt = conn.prepareStatement(sqlBoardList);
			// 3-3 DB 에 쿼리를 발행하고 테이블에서 조회한 결과 집합을 받는다.
			rs = pstmt.executeQuery();

			bList = new ArrayList<>();
			// 동적배열 구조. / 요소를 추가, 제거, 검색할 수 있습니다. <> --- 제네릭

			// 4. 한 행씩 데이터를 추출해서 DrumList 객체 담고 List 에 담는다.
			while (rs.next()) {
				// 4-1 객체생성
				DrumList d = new DrumList();
				d.setNo(rs.getInt(1));
				d.setName("name");
				d.setSum("sum");
				d.setNumber("number");
				d.setBrand("brand");
				d.setMemo("Memo");;

				bList.add(d); // 추가하는 매서드
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 예외처리
		} finally { // 4-2 예외가 발생하든 발생 안 하든 무조건 발생하는 블록이다.
			try {
				// DB 작업에 사용한 자원을 해제 - 앞에서 가져온 역순으로 닫는다.
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bList; // 다시 DrumController 로 돌아간다.
	} // end boardList()
} // end class