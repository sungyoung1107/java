package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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

	// 사용자의 계좌 조회
	// obj : 사용자의 id;
	// Object obj = new String();
	@Override
	public List<AccountDTO> search(Object obj) throws Exception {
		List<AccountDTO> list = new ArrayList<>();
		Collection<AccountDTO> col = db.values();
		
		for(AccountDTO acc : col) {
			if (acc.getHolder().equals(obj)) {
				list.add(acc);
			}
		}

//		for(int i = 0; i < col.size() ; i++) {
//			list.add(col[i]); // 해당 for문으로 접근??
//		}
		
//		 이것도 가능
//		Set<String> setofkey = db.keySet(); // id를 끄집어 낸다.
//		for (String data : setofkey) {
//			if(data == obj) {
//				list.add(db.get(obj)); // list에 id 값이 같은 db 정보를 add
//			}
//		}
		
		return list;
	}

}
