package com.test.ch01;

public class Information {
	private int no;
	private String name;
	private String email1;
	private String member;
	private String id;
	private String pass;

	public Information() {

	}

	public Information(int no, String name, String email1, String member, String id, String pass) {
		super();
		this.no = no;
		this.name = name;
		this.email1 = email1;
		this.member = member;
		this.id = id;
		this.pass = pass;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
