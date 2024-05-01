package com.test.ch02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



// DB Connection 을 관리하는 클래스
public class DBManager {

	private static DataSource DS = null;

	private static Connection CONN = null;

	private DBManager() {

	}

	static {
		try {
			Context initContext = new InitialContext();

			Context envContext = (Context) initContext.lookup("java:comp/env");

			DS = (DataSource) envContext.lookup("jdbc/bbsDBPool");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DBMS 에 접속하고 활성화된 Connection 객체를 반환하는 메소드
	public static Connection getConnection() {

		try {
			CONN = DS.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return CONN;
	} // end getConnection

	// DB 작업에 사용된 자원을 해제하는 메소드
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end close
	
	// DB 작업에 사용된 자원을 해제하는 메소드
	public static void close(Connection conn,
			PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} // end close
	
	// Transaction 시작
	public static void setAutoCommit(Connection conn, boolean isAutoCommit) {
		try {
			if(conn != null)
				conn.setAutoCommit(isAutoCommit);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} // end setAutoCommit
	
	// Transaction 종료
	public static void commit(Connection conn) {
		try {
			if(conn != null)
				conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} // end commit
	
	// Transaction 롤백
	public static void rollback(Connection conn) {
		try {
			if(conn != null)
				conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} // end rollback
	
	
}
