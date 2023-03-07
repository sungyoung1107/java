package com.kbstar.DAO;

import com.kbstar.DTO.ItemDTO;
import com.kbstar.frame.DAO;


// DAO 설계할 때는 범용적으로 설계. 

public class ItemDAO implements DAO<Integer, ItemDTO>{

	@Override
	public void insert(ItemDTO v) {
		connect();
		System.out.println(v);
		System.out.println("insert...");
		close();	
	}

	// int id = 100; int primitive type은 객체 타입인 Integer에 넣을 수 있다.
	@Override
	public void delete(Integer K) {
		connect();
		System.out.println(K);
		System.out.println("delete...");
		close();	
	}

	@Override
	public void update(ItemDTO v) {
		connect();
		System.out.println(v);
		System.out.println("update...");
		close();	
	}

}
