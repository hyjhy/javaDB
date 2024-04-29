package com.test.ch02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.ch01.Board;
import com.test.ch01.Information;

public class BoardDao {

	private Connection conn;

	private PreparedStatement pstmt;

	private ResultSet rs;

	private static DataSource ds;

	public boolean isPassCheck(int no, String pass) {
		boolean isPass = false;
		String sqlPass = "select pass from vata where no=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlPass);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				isPass = rs.getString(1).equals(pass);
			}
		} catch (SQLException e) {
			System.out.println("BoardDao - isPassCheck() : SQLException");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(SQLException e) {
				
			}
		}
		return isPass;
	}
	
	public void updateBoard(Board board) {
		String fileUpdate = board.getFile1() != null ? ", file1 = ?" : "";
		String sqlUpdate = "update vata set title=?, name=?,"
				+ "reg_date=SYSDATE" + fileUpdate + "where no=?";
		
		try {
			conn=ds.getConnection();
			
			pstmt = conn.prepareStatement(sqlUpdate);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			
			if(board.getFile1() != null) {
				pstmt.setString(3, board.getFile1());
				pstmt.setInt(4, board.getNo());
			}else {
				pstmt.setInt(4, board.getNo());
			}
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("BoardDao - updateBoard() : SQLException");
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(SQLException se) {
				
			}
		}
		
	}

	public Board getBoard(int no) {

		String sqlBoard = "select * from vata where no=?";
		Board board = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlBoard);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Board();

				board.setNo(rs.getInt("no"));
				board.setName(rs.getString("title"));
				board.setRegDate(rs.getTimestamp("reg_data"));
				board.setReadCount(rs.getInt("read_count"));
				board.setPass(rs.getString("pass"));
				board.setFile1(rs.getString("file1"));
			}
		} catch (SQLException e) {
			System.out.println("BoardDao - getBoard() : SQLException");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

			}
		}
		return board;
	}

	public void insertBoard(Board board) {

		String sqlInsert = "insert into vata (no, title, name, reg_date, read_count, pass, file1) "
				+ "values (vata_seq.nextval, ?, ?, SYSDATE, 123, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlInsert);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getFile1());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void insertMation(Information mation) {
//insert into information (no, name, email1, member, id, pass) values (information_seq.nextval, 'name','emil@naver.com', 01012341234 , 'name', 'pass');
		String sqlInsert = "insert into information (no, name, email1, member, id, pass) "
				+ "values (vata_seq.nextval, ?, ?, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlInsert);

			pstmt.setString(1, mation.getName());
			pstmt.setString(2, mation.getEmail1());
			pstmt.setString(3, mation.getMember());
			pstmt.setString(4, mation.getId());
			pstmt.setString(5, mation.getPass());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public BoardDao() {

		try {
			Context initContext = new InitialContext();

			Context envContext = (Context) initContext.lookup("java:/comp/env");

			ds = (DataSource) envContext.lookup("jdbc/bbsDBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	} // end BoardDao

	public int getBoardCount() {
		String sqlCount = "select count(*) from vata";
		int count = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sqlCount);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

			}
		}
		return count;
	}

	public ArrayList<Board> boardList(int startRow, int endRow) {
		String sqlBoardList = "select * from (select rownum num, sub.* from (select * from vata order by no desc) sub) where num >= ? and num <= ?";

		ArrayList<Board> boardList = null;

		try {
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sqlBoardList);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();

			boardList = new ArrayList<Board>(); // 게시글 리스트를 저정할 ArrayList 객체생성

			while (rs.next()) {
				Board b = new Board();

				b.setNo(rs.getInt("no"));
				b.setTitle(rs.getString("title"));
				b.setName(rs.getString("name"));
				b.setRegDate(rs.getTimestamp("reg_date"));
				b.setFile1(rs.getString("file1"));
//				b.setId(rs.getString("id"));
				b.setPass(rs.getString("pass"));

				boardList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return boardList;
	}
}
