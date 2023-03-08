package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;

public class ItemDAO implements DAO<Integer, ItemDTO>{

	Map<Integer, ItemDTO> db = null;

	public ItemDAO() {
		db = new HashMap<Integer, ItemDTO>();
		
	}
		
	@Override
	public void insert(ItemDTO v) throws Exception {
		
		if(db.containsKey(v.getId())) {
			throw new Exception(v.getId()+"는 이미 존재하는 ID 입니다");
		}
		db.put(v.getId(), v);
		
	}

	@Override
	public void update(ItemDTO v) throws Exception {
		if(!db.containsKey(v.getId())) {
			throw new Exception(v.getId()+"는 존재하지 않는 ID 입니다");
		}
		db.put(v.getId(), v);
	}

	@Override
	public void delete(Integer k) throws Exception {
		if(!db.containsKey(k)) {
			throw new Exception(k+"는 존재하지 않는 ID 입니다");
		}
		db.remove(k);
		System.out.println(k+"번, 삭제 완료되었습니다.");
	}

	@Override
	public ItemDTO select(Integer k) throws Exception {
		ItemDTO selectedDTO = db.get(k);
		
		if(!db.containsKey(k)) {
			throw new Exception(k+"는 존재하지 않는 ID 입니다");
		}
		
		return selectedDTO;
	}

	@Override
	public List<ItemDTO> select() throws Exception {
		List<ItemDTO> list = new ArrayList<>(); // list 객체 생성
		
		if(db.size()==0) {
			throw new Exception("데이터가 없습니다. 데이터를 먼저 추가해주세요.");
		}
		
		Collection<ItemDTO> col= db.values(); // db에서 value인 ItemDTO를 가져온다.
		
		for(ItemDTO data : col) {
			list.add(data);
		}
	
		return list;
	}
	

}
