package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;

public class AccountDAO implements DAO<String, AccountDTO>{
	
	HashMap<String, AccountDTO> db;
	
	public AccountDAO() {
		db = new HashMap<>();
	}

	@Override
	public void insert(AccountDTO v) throws Exception {
		
		if(db.containsKey(v.getAccNo())) {
			System.out.println("id가 없습니다.");
			throw new Exception("101"); // 100 : 에러코드
		}
		
		db.put(v.getAccNo(), v);
		
	}

	@Override
	public void delete(String k) throws Exception {
		
		if(!db.containsKey(k)) {
			System.out.println("id가 없습니다.");
			throw new Exception("101"); // 101 : 에러코드
		}
		
		db.remove(k);
		
	}

	@Override
	public void update(AccountDTO v) throws Exception {
		
		if(!db.containsKey(v.getAccNo())) {
			System.out.println("id가 없습니다.");
			throw new Exception("101"); // 101 : 에러코드
		}
		
		db.put(v.getAccNo(), v);
		
	}

	@Override
	public AccountDTO select(String k) throws Exception {
		
		if(!db.containsKey(k)) {
			System.out.println("id가 없습니다");
			throw new Exception("101"); // 101 : 에러코드
		}
		
		AccountDTO obj = null;
		obj = db.get(k);
		return obj;
		
	}

	@Override
	public List<AccountDTO> select() throws Exception {
		
		List<AccountDTO> list= new ArrayList<>();
		Collection<AccountDTO> col = db.values();
		
		if(db.size()==0) {
			System.out.println("list 내용이 없습니다");
			throw new Exception("102"); // 102 : 에러코드
		}
	
		for (AccountDTO data : col) {
			list.add(data);
		}
		
		return list;
	}

}
