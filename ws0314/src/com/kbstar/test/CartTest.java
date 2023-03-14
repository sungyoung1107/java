package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartTest {

	public static void main(String[] args) {

		CRUDService<String, Cart> service = null;
		service = new CartCRUDServiceImpl();

		// 등록
		Cart cart1 = new Cart("id009", 10); // userid
		try {
			service.register(cart1);
			System.out.println("추가성공");
			System.out.println(service);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Cart cart2 = new Cart("id003", 10); // userid
		try {
			service.register(cart2);
			System.out.println("추가성공");
			System.out.println(service);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// 삭제
		try {
			service.remove("2023314711101");
			System.out.println("삭제성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// 수정
		Cart cart3 = new Cart("2023314856101", 100, "2023314856101");
		try {
			service.modify(cart3);
			System.out.println("수정성공");
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// 부분검색
		try {
			System.out.println("부분검색을 시작합니다");
			Cart cart4 = service.get("2023314144101");
			System.out.println(cart4.getId() + ", " + cart4.getUser_id() + ", " + cart4.getItem_id() + ", "
					+ cart4.getCnt() + ", " + cart4.getRegdate());
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// 전체검색
		try {
			System.out.println("전체검색을 시작합니다");
			List<Cart> list = service.get();

			for (Cart data : list) {
				System.out.println(data.getId() + ", " + data.getUser_id() + ", " + data.getItem_id() + ", "
						+ data.getCnt() + ", " + data.getRegdate());
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
