package com.kbstar.test;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemUpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CRUDService<String, Item> service = new ItemCRUDServiceImpl();

		// update(202331476100)
		try {
			Item item = new Item("2023314506100", "socks", 30000, 3.1);
			service.modify(item);
			System.out.println("수정완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}



	}

}
