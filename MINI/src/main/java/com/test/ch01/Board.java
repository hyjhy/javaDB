package com.test.ch01;

import java.sql.Timestamp;

public class Board {
	private int no;
	private String title;
	private String name;
	private Timestamp regDate;
	private String file1;
	private int readCount;
	private String pass;

	public Board() {

	}

	public Board(int no, String title, String name, Timestamp regDate, String file1, int readCount, String pass) {
		super();
		this.no = no;
		this.title = title;
		this.name = name;
		this.regDate = regDate;
		this.file1 = file1;
		this.readCount = readCount;
		this.pass = pass;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}