package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.DAO;

public class TransactionDAO implements DAO<String, TransactionDTO>{
	
	Map<String, TransactionDTO> db;
	
	public TransactionDAO() {
		db = new HashMap<>();
	}

	@Override
	public void insert(TransactionDTO v) throws Exception {
		
		if(db.containsKey(v.getDate())){
			throw new Exception("입력 오류");
		}
		
		db.put(v.getDate(), v);	
	}

	@Override
	public void delete(String k) throws Exception {
//		db.remove(k);
		
	}

	@Override
	public void update(TransactionDTO v) throws Exception {
//		db.put(v.getDate(), v);
		
	}

	@Override
	public TransactionDTO select(String k) throws Exception {
		TransactionDTO obj = null;
		
		if(!db.containsKey(k)) {
			throw new Exception("조회 오류");
		}
		
		obj = db.get(k);
		return obj;
	}

	@Override
	public List<TransactionDTO> select() throws Exception {
		List<TransactionDTO> list = new ArrayList<>();
		Collection<TransactionDTO> col = db.values();
		
		if(db.size()==0) {
			throw new Exception("전체 조회 오류");
		}
		
		for (TransactionDTO data : col) {
			list.add(data);
		}
		
		return list;
	}
	
	public void transfer() {
		
	}

	// 고객이 보유하고 있는 계좌번호를 입력하면
	// 해당 계좌의 거래 내역을 조회 한다.
	@Override
	public List<TransactionDTO> search(Object obj) throws Exception {
		List<TransactionDTO> list = new ArrayList<>();
//		Set<String> setofkey = db.keySet();
//		
//		for (String data : setofkey) {
//			if(data == obj) {
//				list.add(db.get(obj)); // list에 id 값이 같은 db 정보를 add
//			}
//		}
//		return list;
		return null;
		
	}

}
