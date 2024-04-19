package com.test.main;

public class Boxdrum {
	private String name, number, sum, brand, memo, img;

	public Boxdrum() {
	}

	public Boxdrum(String name, String number, String sum, String brand, String memo, String img) {
		super();
		this.name = name;
		this.number = number;
		this.sum = sum;
		this.brand = brand;
		this.memo = memo;
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

}
