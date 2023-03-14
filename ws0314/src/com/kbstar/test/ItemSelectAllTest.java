package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemSelectAllTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CRUDService<String, Item> service = new ItemCRUDServiceImpl();

		// selectAll
		try {
			List<Item> list = service.get();
			for (Item item : list) {
				System.out.println(item.getId() + ", " + item.getName() + ", " + item.getPrice() + ", " + item.getRate()
						+ ", " + item.getRegdate());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
