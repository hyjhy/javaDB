package com.test.cotroller;

public class DrumList {
// 1. 생성자를 만들어준다.
	private int no;
	private String name;
	private String sum;
	private String number;
	private String brand;
	private String memo;

// 2. public 매서드를 만들어주고 현재 매서드와 같은 이름으로 생성한다.
	public DrumList() {
		// 빈 공간으로 둔다.
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

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public DrumList(int no, String name, String sum, String number, String brand, String memo) {
		super();
		this.no = no;
		this.name = name;
		this.sum = sum;
		this.number = number;
		this.brand = brand;
		this.memo = memo;
	}

//3-1 ( source - Generate getters and setters 들어가서 생성자를 생성해준다. )
//3-2 ( source - Generate constructor using fields 들어가서 생성자를 생성해준다. )
	// 4. end - 생성만 만들어주고 더이상 수정은 없는 java 폴더 입니다.

	

}
