package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;
import com.kbstar.service.CustCRUDServiceImpl;
import com.kbstar.service.ItemCRUDServiceImpl;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String menu;
		String name;
		String id;
		String pwd;
		int age;

		CRUDService<String, Cust> custservice = new CustCRUDServiceImpl();
		CRUDService<String, Item> itemservice = new ItemCRUDServiceImpl();
		CRUDService<String, Cart> cartservice = new CartCRUDServiceImpl();

		// INTRO //
		System.out.println("== 안녕하십니까 고객님, KB스타프렌즈몰에 오신 것을 환영합니다! ==");

		// MENU : < 1. KB스타프렌즈몰 가입, 2. KB스타프렌즈몰 로그인, 3. KB스타프렌즈몰 상품 보기, 4. 나의 카트 보기, 5.
		// 나가기 > //
		while (true) {
			System.out.println("== 거래하실 메뉴를 번호로 입력해주세요 == ");
			System.out.println("< 1. KB스타프렌즈몰 가입, 2. KB스타프렌즈몰 로그인, 3. KB스타프렌즈몰 전체 상품 보기, 4. 나의 카트 보기, 5. 나가기 > ");
			menu = sc.next(); // 첫번째 메뉴를 입력받는다.

			try {
				if (Integer.parseInt(menu) == 5) {
					System.out.println("== 고객님 KB국민은행을 거래해주셔서 감사합니다 == ");
					break;
				} else if (Integer.parseInt(menu) == 1) { // 신규가입 화면
					System.out.println("== KB스타프렌즈 신규가입 화면입니다 ==");

					// 이름
					System.out.println("== 고객님의 이름을 입력해주세요 ==");
					name = sc.next();

					// 아이디
					System.out.println("== 신규하실 id를 입력해주세요 ==");
					id = sc.next();

					// 패스워드
					System.out.println("== 등록하실 pw를 입력해주세요 ==");
					pwd = sc.next();

					// 나이
					System.out.println("== 추천상품을 위해 고객님의 나이를 입력해주세요 ==");
					age = Integer.parseInt(sc.next());

					// 객체에 넣는다.
					Cust cust = new Cust(id, pwd, name, age);
					try {
						custservice.register(cust);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}

				} else if (Integer.parseInt(menu) == 2) { // 로그인 화면
					System.out.println("== KB스타프렌즈 로그인 화면입니다 ==");

				} else if (Integer.parseInt(menu) == 3) { // 상품보기 화면

				} else if (Integer.parseInt(menu) == 4) { // 나의 카트 보기

				} else {
					System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
				}
			} catch (NumberFormatException e) {
				System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
			}
		}

		sc.close();

	}

}
