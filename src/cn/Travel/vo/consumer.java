package cn.Travel.vo;

import java.sql.Date;



public class consumer {
    private String usename;
    private String id;
    private String note;
    private String data;
    private String price;
    private String photo;
    private int limit1;
    private int limit2;
	
	public int getLimit1() {
		return limit1;
	}
	public void setLimit1(int limit1) {
		this.limit1 = limit1;
	}
	public int getLimit2() {
		return limit2;
	}
	public void setLimit2(int limit2) {
		this.limit2 = limit2;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
