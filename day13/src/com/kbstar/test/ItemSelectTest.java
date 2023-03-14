package com.kbstar.test;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemSelectTest {

	public static void main(String[] args) {
		
		CRUDService<String, Item> service = new ItemCRUDServiceImpl();

		// select(2023314997100)
		try {
			Item item = service.get("2023314997100");
			System.out.println(item.getId()+", "+item.getName()+", "+item.getPrice()+", "+ item.getRate()+", "+item.getRegdate());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
