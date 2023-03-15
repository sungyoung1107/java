package com.kbstar.dto;

import java.sql.Date;

import com.kbstar.dao.CustDaoImpl;
import com.kbstar.dao.DAO;

public class Cart {

	private String id; // 자동생성
	private String user_id; // 사용자 id(cust id)
	private String item_id; // 상품 id(item id)
	private int cnt; // 상품 갯수
	private Date regdate; // 상품 등록일자

	DAO<String, String, Cust> cust; // cust 정보를 가지고 있는 객체를 선언한다.

	public Cart() {
		cust = new CustDaoImpl(); // cust 정보를 가지고 있는 객체를 만든다.
	}

	public Cart(String user_id, int cnt) {
		this.user_id = user_id;
		this.cnt = cnt;
	}

	public Cart(String item_id, int cnt, String id) {
		this.item_id = item_id;
		this.cnt = cnt;
		this.id = id;
	}

	public Cart(String id, String user_id, String item_id, int cnt, Date regdate) {
		this.id = id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.cnt = cnt;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
