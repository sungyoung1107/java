package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.frame.ShopService;
import com.kbstar.service.ShopServiceImpl;

public class MyCartSelectAllTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShopService<Cust, Cart> service = new ShopServiceImpl();

		// selectAll
		try {
			List<Cart> list = service.myCart("id003");
			for (Cart item : list) {
				System.out.println(item.getId() + ", " + item.getItem_id() + ", " + item.getUser_id() + ", "
						+ item.getCnt() + ", " + item.getRegdate());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
