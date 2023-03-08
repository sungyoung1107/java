package com.kbstar.dto;

public class ItemDTO {
	
	private int id; // 상품번호 (primary key)
	private String name; // 상품이름
	private double price; // 상품가격
	private int qt; // 상품갯수
	
	public ItemDTO() {
		
	}
	
	public ItemDTO(int id, String name, double price, int qt) throws Exception {
		this.id = id;
		this.name = name;
		if (price < 0) {
			throw new Exception("가격은 음수 불가합니다.");
		}
		this.price = price;
		if (qt < 0) {
			throw new Exception("수량은 음수 불가합니다.");
		}
		this.qt = qt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemDTO [id=").append(id).append(", name=").append(name).append(", price=").append(price)
				.append(", qt=").append(qt).append("]");
		return builder.toString();
	}

}
