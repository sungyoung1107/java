package com.kbstar.service;

import com.kbstar.DAO.ItemDAO;
import com.kbstar.DTO.ItemDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.SearchService;
import com.kbstar.frame.Service;

public class ItemService implements Service<Integer, ItemDTO>, SearchService {

//	DAO dao; 
//	어떻게 DAO를 사용하시겠습니까? Integer과 ItemDTO를 넣어서 사용하겠습니다.
	DAO<Integer, ItemDTO> dao;
//  객체를 생성해야 사용 가능하다. 생성자에서 생성하겠다.
	
	public ItemService() {
		dao = new ItemDAO(); // ItemDAO는 DAO 인터페이스를 상속 받아 실제로 함수가 구현된 클래스이다.
		// promotion . 상위 인터페이스에 하위 객체를 넣는 것! // 다형성의 특징
		// ItemDAO로 이용할 떄는 오라클이지만 예를 들어 ItemORACLEDAO로 저 부분만 바꿔주면 Oracle에 넣는 함수가 구현되어 있는
		// ItemORACLEDAO 명칭으로만 바꿔주면 된다.
	}
	
	@Override
	public void register(ItemDTO v) {
		System.out.println(v + "Data check...");
		// DB에 넣자. 넣기 위해서는 DAO가 필요하다.
		dao.insert(v);
		System.out.println("register 완료");
		
	}

	@Override
	public void remove(Integer k) {
		System.out.println(k + "Data check...");
		// DB에 넣자. 넣기 위해서는 DAO가 필요하다.
		dao.delete(k);
		System.out.println("remove 완료");
		
	}

	@Override
	public void modify(ItemDTO v) {
		System.out.println(v + "Data check...");
		// DB에 넣자. 넣기 위해서는 DAO가 필요하다.
		dao.update(v);
		System.out.println("remove 완료");
		
	}

	@Override
	public void search() {
		System.out.println("Data check...");
		// DB에 넣자. 넣기 위해서는 DAO가 필요하다
		System.out.println("search 완료");
		
	}
	
	

//	@Override
//	public void search() {
//		// TODO Auto-generated method stub
//		
//	}
	
//	// search 하는 함수 추가 하고 싶다.
//	public void search() {
//		System.out.println("Search");
//	}
	
}
