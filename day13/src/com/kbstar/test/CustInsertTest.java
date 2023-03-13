package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustInsertTest {

	public static void main(String[] args) {
		
		CRUDService<String, Cust> crudService = null;
		crudService = new CustCRUDServiceImpl();
		
		// 등록
		Cust cust = new Cust("id50", "pwd26", "tom", 30);
		try {
			crudService.register(cust);
			System.out.println("추가성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		// 삭제
		try {
			crudService.remove("id300");
			System.out.println("삭제성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Cust cust1 = new Cust("id50", "pwd26", "tom", 30);
		try {
			crudService.register(cust1);
			System.out.println("추가성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		// 수정
		Cust cust2 = new Cust("id33", "pwd26", "유재석", 30);
		try {
			crudService.modify(cust2);
			System.out.println("수정성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		// KEY검색
		try {
			System.out.println("검색을 시작합니다");
			Cust cust3 = crudService.get("id301");
			System.out.println(cust3.getId() + ", " + cust3.getPwd() + ", " + cust3.getName() + ", " + cust.getAge());
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("여기인가");
			System.out.println(e.getMessage());
		}
		
		// 전체검색
		try {
			System.out.println("전체검색을 시작합니다");
			List<Cust> list = crudService.get();
			
			for (Cust data : list) {
				System.out.println(data.getId() + ", " + data.getPwd() + ", " + data.getName() + ", " + data.getAge());	
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("여기인가");
			System.out.println(e.getMessage());
		}

	}

}
