package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountService;

public class AccountRegisterTest {
	
	public static void main(String[] args) {
		
		CRUDService<String, AccountDTO> service = new AccountService();
		AccountDTO obj1 = new AccountDTO("101", 100, "이성영"); // 데이터 객체
		AccountDTO obj2 = new AccountDTO("100", 200, "이뭉치"); 
		AccountDTO obj3 = new AccountDTO("102", 300, "김말자"); 
		
//		// 입력
		try {
			service.register(obj1);
			service.register(obj2);
			service.register(obj3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------입력-------------");
		
		// 삭제
//		try {
//			service.remove("104");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//		System.out.println("-------------삭제-------------");
		
		// 수정하기
//		try {
//			service.modify(new AccountDTO("102", 200, "이망치"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
		
		try {
			service.modify(new AccountDTO("1033", 200, "이망치"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("-------------수정-------------");
		
		// 부분 보여주기
		try {
			System.out.println(service.get("102"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("---------부분 보여주기-----------");
		
		// 전체 보여주기
		try {
			List<AccountDTO> accdto = service.get();
			for (AccountDTO data: accdto) {
				System.out.println(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("---------전체 보여주기-----------");
		
		
	}

}
